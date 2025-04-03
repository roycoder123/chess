//Author: Roy Rozin 
//Piece Name: Magician 
//Description: Copies the legal moves of the piece the opponent just moved 
//(can't move on first turn or if the opponent's turn was a magician move)
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Magician extends Piece {
    private Board b;

    public Magician(Board board, boolean isWhite, String img_file) {
        super(isWhite, img_file);
        b = board;
    }
    
    public String toString() {
        return "A " + super.toString() + " magician";
      }
    

    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> controlledSquares = new ArrayList<Square>();
      if(b.getPreviousPiece()!= null)
      controlledSquares = b.getPreviousPiece().getLegalMoves(b, start);
      return controlledSquares;
    }
      
    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.

    public ArrayList<Square> getLegalMoves(Board b, Square start){
      ArrayList<Square> moves = new ArrayList<Square>();
      //the magician copies the legal moves of the piece that the opponent just moved
      //Pre condition: can't be the first turn and also the previous move of the opponent can't be the magician (the magician can't copy the magician)
      if(b.getTurnCount() != 0 && b.getPreviousPiece() != null && !(b.getPreviousPiece() instanceof Magician)){
          b.getPreviousPiece().setColor(!b.getPreviousPiece().getColor());
          moves = b.getPreviousPiece().getLegalMoves(b, start);
          b.getPreviousPiece().setColor(!b.getPreviousPiece().getColor());
      }
      return moves;
    } 
}