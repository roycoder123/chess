import java.util.ArrayList;

public class King extends Piece {
    public King(boolean isWhite, String img_file){
        super(isWhite, img_file);
    }
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        ArrayList<Square> controlledSquares = new ArrayList<Square>();
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
        return controlledSquares;
    }

    public ArrayList<Square> getLegalMoves(Board b, Square start){
        ArrayList<Square> moves = new ArrayList<Square>();
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
        return moves;  
    }
}
