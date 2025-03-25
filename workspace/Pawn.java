import java.util.ArrayList;

public class Pawn extends Piece{
    public Pawn(boolean isWhite, String img_file){
        super(isWhite, img_file);
    }
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
      ArrayList<Square> controlledSquares = new ArrayList<Square>();
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
          return controlledSquares;
        }
        
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        ArrayList<Square> moves = new ArrayList<Square>();
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
        return moves;
    }
}

