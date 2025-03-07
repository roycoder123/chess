
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
public class Piece {
    private boolean color;
    private BufferedImage img;
    private String name;
    
    public Piece(boolean isWhite, String name, String img_file) {
        this.color = isWhite;
        this.name = name;
        
        try {
            if (this.img == null) {
              this.img = ImageIO.read(getClass().getResource(img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }

    public String getName(){
      return name;
    }
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> controlledSquares = new ArrayList<Square>();
      //rook
      if(start.getOccupyingPiece().getName().equals("rook")){
        //column wise
        for(int i = start.getRow()+1; i <= 7; i++){
          Square currentSquare = board[i][start.getCol()];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
        }

        for(int i = start.getRow()-1; i >= 0; i--){
          Square currentSquare = board[i][start.getCol()];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
        }

        //row wise
        for(int i = start.getCol()-1; i >= 0; i--){
          Square currentSquare = board[start.getRow()][i];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
        }
        for(int i = start.getCol()+1; i < 8; i++){
          Square currentSquare = board[start.getRow()][i];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
        }
      }


      //bishop
      if(start.getOccupyingPiece().getName().equals("bishop")){
      int row = start.getRow();
      int col = start.getCol();
        //up left
        row = start.getRow() - 1;
        col = start.getCol() - 1;
        while(row >= 0 && col >= 0){
        Square currentSquare = board[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
          row--;
          col--;
        }
        //up right
        row = start.getRow() - 1;
        col = start.getCol() + 1;
        while(row >= 0 && col < 8){
        Square currentSquare = board[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
          row--;
          col++;
        }
        //down left
        row = start.getRow() + 1;
        col = start.getCol() - 1;
        while(row < 8 && col >= 0){
        Square currentSquare = board[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
          row++;
          col--;
        }
        //down right
        row = start.getRow() + 1;
        col = start.getCol() + 1;
        while(row < 8 && col < 8){
        Square currentSquare = board[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
          row++;
          col++;
        }
      }
      if(start.getOccupyingPiece().getName().equals("queen")){
        //column wise
        for(int i = start.getRow()+1; i <= 7; i++){
          Square currentSquare = board[i][start.getCol()];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
        }

        for(int i = start.getRow()-1; i >= 0; i--){
          Square currentSquare = board[i][start.getCol()];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
        }

        //row wise
        for(int i = start.getCol()-1; i >= 0; i--){
          Square currentSquare = board[start.getRow()][i];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
        }
        for(int i = start.getCol()+1; i < 8; i++){
          Square currentSquare = board[start.getRow()][i];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
        }

        int row = start.getRow();
      int col = start.getCol();
        //up left
        row = start.getRow() - 1;
        col = start.getCol() - 1;
        while(row >= 0 && col >= 0){
        Square currentSquare = board[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
          row--;
          col--;
        }
        //up right
        row = start.getRow() - 1;
        col = start.getCol() + 1;
        while(row >= 0 && col < 8){
        Square currentSquare = board[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
          row--;
          col++;
        }
        //down left
        row = start.getRow() + 1;
        col = start.getCol() - 1;
        while(row < 8 && col >= 0){
        Square currentSquare = board[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
          row++;
          col--;
        }
        //down right
        row = start.getRow() + 1;
        col = start.getCol() + 1;
        while(row < 8 && col < 8){
        Square currentSquare = board[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(currentSquare);
            }
            break;
          }
          controlledSquares.add(currentSquare);
          row++;
          col++;
        }
      }
      if(start.getOccupyingPiece().getName().equals("knight")){
        int[] rowDiffs = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] colDiffs = {-1, 1, -2 , 2, -2, 2, -1, 1};
        for(int i = 0; i < 8; i++){
          int newRow = start.getRow() + rowDiffs[i];
          int newCol = start.getCol() + colDiffs[i];
          if(newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8){
            Square targetSquare = board[newRow][newCol];
            if(!targetSquare.isOccupied() || targetSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              controlledSquares.add(targetSquare);
            }
          }
        }
      }
      if(start.getOccupyingPiece().getName().equals("king")){
        //up left
      if(start.getRow() - 1 >= 0 && start.getCol() - 1 >= 0){
        Square upLeft = board[start.getRow() - 1][start.getCol() - 1];
        if(!upLeft.isOccupied() || upLeft.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          controlledSquares.add(upLeft);
        }
      }
      //up
      if(start.getRow() - 1 >= 0){
        Square up = board[start.getRow() - 1][start.getCol()];
        if(!up.isOccupied() || up.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          controlledSquares.add(up);
        }
      }
      //up right
      if(start.getRow() - 1 >= 0 && start.getCol() + 1 < 8){
        Square upRight = board[start.getRow() - 1][start.getCol() + 1];
        if(!upRight.isOccupied() || upRight.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          controlledSquares.add(upRight);
        }
      }
      //right
      if(start.getCol() + 1 < 8){
        Square right = board[start.getRow()][start.getCol() + 1];
        if(!right.isOccupied() || right.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          controlledSquares.add(right);
        }
      }
      //down right
      if(start.getRow() + 1 < 8 && start.getCol() + 1 < 8){
        Square downRight = board[start.getRow() + 1][start.getCol() + 1];
        if(!downRight.isOccupied() || downRight.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          controlledSquares.add(downRight);
        }
      }
      //down
      if(start.getRow() + 1 < 8){
        Square down = board[start.getRow() + 1][start.getCol()];
        if(!down.isOccupied() || down.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          controlledSquares.add(down);
        }
      }
      //down left
      if(start.getRow() + 1 < 8 && start.getCol() - 1 >= 0){
        Square downLeft = board[start.getRow() + 1][start.getCol() - 1];
        if(!downLeft.isOccupied() || downLeft.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          controlledSquares.add(downLeft);
        }
      }
      //left
      if(start.getCol() - 1 >= 0){
        Square left = board[start.getRow()][start.getCol() - 1];
        if(!left.isOccupied() || left.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          controlledSquares.add(left);
        }
      }
      }
      if(start.getOccupyingPiece().getName().equals("pawn")){
        //for white pawn
        if(start.getOccupyingPiece().getColor()){
            if(start.getCol() + 1 < 8){
              Square rightCapture = board[start.getRow() + 1][start.getCol() + 1];
              if(rightCapture.isOccupied() || !rightCapture.getOccupyingPiece().getColor()){
                controlledSquares.add(rightCapture);
              }
            }
            if(start.getCol() - 1 >= 0){
              Square leftCapture = board[start.getRow() + 1][start.getCol() - 1];
              if(leftCapture.isOccupied() || !leftCapture.getOccupyingPiece().getColor()){
                controlledSquares.add(leftCapture);
              }
            } 
          }
        
        //for black pawn
        if(!start.getOccupyingPiece().getColor()){
            if(start.getCol() + 1 < 8){
              Square rightCapture = board[start.getRow() - 1][start.getCol() + 1];
              if(rightCapture.isOccupied() || rightCapture.getOccupyingPiece().getColor()){
                controlledSquares.add(rightCapture);
              }
            }
            if(start.getCol() - 1 >= 0){
              Square leftCapture = board[start.getRow() - 1][start.getCol() - 1];
              if(leftCapture.isOccupied() || leftCapture.getOccupyingPiece().getColor()){
                controlledSquares.add(leftCapture);
              }
            } 
          }
        }
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
      // if(b.getPreviousPiece()== null){
      //   return moves;
      // }
      if(start.getOccupyingPiece().getName().equals("magician")){
          b.getPreviousPiece().color = !b.getPreviousPiece().color;
          moves = b.getPreviousPiece().getLegalMoves(b, start);
          b.getPreviousPiece().color = !b.getPreviousPiece().color;
          return moves;
        }
         
      //QUEEN
      if(start.getOccupyingPiece().getName().equals("queen")){
        //rook movement
        //column wise
        for(int i = start.getRow()+1; i <= 7; i++){
          Square currentSquare = b.getSquareArray()[i][start.getCol()];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
        }

        for(int i = start.getRow()-1; i >= 0; i--){
          Square currentSquare = b.getSquareArray()[i][start.getCol()];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
        }

        //row wise
        for(int i = start.getCol()-1; i >= 0; i--){
          Square currentSquare = b.getSquareArray()[start.getRow()][i];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
        }
        for(int i = start.getCol()+1; i < 8; i++){
          Square currentSquare = b.getSquareArray()[start.getRow()][i];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
        }

        //bishop movement
        int row = start.getRow();
        int col = start.getCol();
        //up left
        row = start.getRow() - 1;
        col = start.getCol() - 1;
        while(row >= 0 && col >= 0){
        Square currentSquare = b.getSquareArray()[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
          row--;
          col--;
        }
        //up right
        row = start.getRow() - 1;
        col = start.getCol() + 1;
        while(row >= 0 && col < 8){
        Square currentSquare = b.getSquareArray()[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
          row--;
          col++;
        }
        //down left
        row = start.getRow() + 1;
        col = start.getCol() - 1;
        while(row < 8 && col >= 0){
        Square currentSquare = b.getSquareArray()[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
          row++;
          col--;
        }
        //down right
        row = start.getRow() + 1;
        col = start.getCol() + 1;
        while(row < 8 && col < 8){
        Square currentSquare = b.getSquareArray()[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
          row++;
          col++;
        }

      }
      //BISHOP
      if(start.getOccupyingPiece().getName().equals("bishop")){
        int row = start.getRow();
        int col = start.getCol();
        //up left
        row = start.getRow() - 1;
        col = start.getCol() - 1;
        while(row >= 0 && col >= 0){
        Square currentSquare = b.getSquareArray()[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
          row--;
          col--;
        }
        //up right
        row = start.getRow() - 1;
        col = start.getCol() + 1;
        while(row >= 0 && col < 8){
        Square currentSquare = b.getSquareArray()[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
          row--;
          col++;
        }
        //down left
        row = start.getRow() + 1;
        col = start.getCol() - 1;
        while(row < 8 && col >= 0){
        Square currentSquare = b.getSquareArray()[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
          row++;
          col--;
        }
        //down right
        row = start.getRow() + 1;
        col = start.getCol() + 1;
        while(row < 8 && col < 8){
        Square currentSquare = b.getSquareArray()[row][col];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
          row++;
          col++;
        }
      
      }
      //KNIGHT
      if(start.getOccupyingPiece().getName().equals("knight")){
        int[] rowDiffs = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] colDiffs = {-1, 1, -2 , 2, -2, 2, -1, 1};
        for(int i = 0; i < 8; i++){
          int newRow = start.getRow() + rowDiffs[i];
          int newCol = start.getCol() + colDiffs[i];
          if(newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8){
            Square targetSquare = b.getSquareArray()[newRow][newCol];
            if(!targetSquare.isOccupied() || targetSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(targetSquare);
            }
          }
        }
      }

      //KING
      if(start.getOccupyingPiece().getName().equals("king")){
      //up left
      if(start.getRow() - 1 >= 0 && start.getCol() - 1 >= 0){
        Square upLeft = b.getSquareArray()[start.getRow() - 1][start.getCol() - 1];
        if(!upLeft.isOccupied() || upLeft.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          moves.add(upLeft);
        }
      }
      //up
      if(start.getRow() - 1 >= 0){
        Square up = b.getSquareArray()[start.getRow() - 1][start.getCol()];
        if(!up.isOccupied() || up.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          moves.add(up);
        }
      }
      //up right
      if(start.getRow() - 1 >= 0 && start.getCol() + 1 < 8){
        Square upRight = b.getSquareArray()[start.getRow() - 1][start.getCol() + 1];
        if(!upRight.isOccupied() || upRight.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          moves.add(upRight);
        }
      }
      //right
      if(start.getCol() + 1 < 8){
        Square right = b.getSquareArray()[start.getRow()][start.getCol() + 1];
        if(!right.isOccupied() || right.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          moves.add(right);
        }
      }
      //down right
      if(start.getRow() + 1 < 8 && start.getCol() + 1 < 8){
        Square downRight = b.getSquareArray()[start.getRow() + 1][start.getCol() + 1];
        if(!downRight.isOccupied() || downRight.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          moves.add(downRight);
        }
      }
      //down
      if(start.getRow() + 1 < 8){
        Square down = b.getSquareArray()[start.getRow() + 1][start.getCol()];
        if(!down.isOccupied() || down.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          moves.add(down);
        }
      }
      //down left
      if(start.getRow() + 1 < 8 && start.getCol() - 1 >= 0){
        Square downLeft = b.getSquareArray()[start.getRow() + 1][start.getCol() - 1];
        if(!downLeft.isOccupied() || downLeft.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          moves.add(downLeft);
        }
      }
      //left
      if(start.getCol() - 1 >= 0){
        Square left = b.getSquareArray()[start.getRow()][start.getCol() - 1];
        if(!left.isOccupied() || left.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
          moves.add(left);
        }
      }
      
      }
        
      //ROOK
      if(start.getOccupyingPiece().getName().equals("rook")){
        //column wise
        for(int i = start.getRow()+1; i <= 7; i++){
          Square currentSquare = b.getSquareArray()[i][start.getCol()];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
        }

        for(int i = start.getRow()-1; i >= 0; i--){
          Square currentSquare = b.getSquareArray()[i][start.getCol()];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
        }

        //row wise
        for(int i = start.getCol()-1; i >= 0; i--){
          Square currentSquare = b.getSquareArray()[start.getRow()][i];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
        }
        for(int i = start.getCol()+1; i < 8; i++){
          Square currentSquare = b.getSquareArray()[start.getRow()][i];
          if(currentSquare.isOccupied()){
            if(currentSquare.getOccupyingPiece().getColor() != start.getOccupyingPiece().getColor()){
              moves.add(currentSquare);
            }
            break;
          }
          moves.add(currentSquare);
        }
      }
      
      
      //PAWN
      if(start.getOccupyingPiece().getName().equals("pawn")){
        //for white pawn
        if(start.getOccupyingPiece().getColor()){
          if(start.getRow() == 1){
            if(!(b.getSquareArray()[2][start.getCol()].isOccupied())){
              moves.add(b.getSquareArray()[2][start.getCol()]);
            }
            if(!(b.getSquareArray()[3][start.getCol()].isOccupied())){
              moves.add(b.getSquareArray()[3][start.getCol()]);
            }
          }
          else{
            if(!(b.getSquareArray()[start.getRow()+1][start.getCol()]).isOccupied()){
              moves.add(b.getSquareArray()[start.getRow()+1][start.getCol()]);
            }
            if(start.getCol() + 1 < 8){
              Square rightCapture = b.getSquareArray()[start.getRow() + 1][start.getCol() + 1];
              if(rightCapture.isOccupied() && !rightCapture.getOccupyingPiece().getColor()){
                moves.add(rightCapture);
              }
            }
            if(start.getCol() - 1 >= 0){
              Square leftCapture = b.getSquareArray()[start.getRow() + 1][start.getCol() - 1];
              if(leftCapture.isOccupied() && !leftCapture.getOccupyingPiece().getColor()){
                moves.add(leftCapture);
              }
            } 
          }
        }
        //for black pawn
        if(!start.getOccupyingPiece().getColor()){
          //first move
          if(start.getRow() == 6){
            if(!(b.getSquareArray()[5][start.getCol()].isOccupied())){
              moves.add(b.getSquareArray()[5][start.getCol()]);
            }
            if(!(b.getSquareArray()[4][start.getCol()].isOccupied())){
              moves.add(b.getSquareArray()[4][start.getCol()]);
            }
          }
          else{
            if(!(b.getSquareArray()[start.getRow()-1][start.getCol()]).isOccupied()){
              moves.add(b.getSquareArray()[start.getRow()-1][start.getCol()]);
            }
            if(start.getCol() + 1 < 8){
              Square rightCapture = b.getSquareArray()[start.getRow() - 1][start.getCol() + 1];
              if(rightCapture.isOccupied() && rightCapture.getOccupyingPiece().getColor()){
                moves.add(rightCapture);
              }
            }
            if(start.getCol() - 1 >= 0){
              Square leftCapture = b.getSquareArray()[start.getRow() - 1][start.getCol() - 1];
              if(leftCapture.isOccupied() && leftCapture.getOccupyingPiece().getColor()){
                moves.add(leftCapture);
              }
            } 
          }
        }
      }
      return moves;
    }
  }
