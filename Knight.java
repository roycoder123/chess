import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(boolean isWhite, String img_file){
        super(isWhite, img_file);
    }
    public ArrayList<Square> getLegalMoves(Board b, Square start){
      ArrayList<Square> moves = new ArrayList<Square>();
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
      return moves;
    }
}