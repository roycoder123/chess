import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(boolean isWhite, String img_file){
        super(isWhite, img_file);
    }
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        ArrayList<Square> controlledSquares = new ArrayList<Square>();
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
        return controlledSquares;
    }
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        ArrayList<Square> moves = new ArrayList<Square>();
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
      return moves;
    }
}
