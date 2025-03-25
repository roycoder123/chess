import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(boolean isWhite, String img_file){
        super(isWhite, img_file);
    }
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        ArrayList<Square> controlledSquares = new ArrayList<Square>();
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
        return controlledSquares;
    }
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        ArrayList<Square> moves = new ArrayList<Square>();
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
        return moves;
    }    
}
