

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;

import javax.swing.*;

//You will be implmenting a part of a function and a whole function in this document. Please follow the directions for the 
//suggested order of completion that should make testing easier.
@SuppressWarnings("serial")
public class Board extends JPanel implements MouseListener, MouseMotionListener {
	// Resource location constants for piece images
    private static final String RESOURCES_WBISHOP_PNG = "wbishop.png";
	private static final String RESOURCES_BBISHOP_PNG = "bbishop.png";
	private static final String RESOURCES_WKNIGHT_PNG = "wknight.png";
	private static final String RESOURCES_BKNIGHT_PNG = "bknight.png";
	private static final String RESOURCES_WROOK_PNG = "wrook.png";
	private static final String RESOURCES_BROOK_PNG = "brook.png";
	private static final String RESOURCES_WKING_PNG = "wking.png";
	private static final String RESOURCES_BKING_PNG = "bking.png";
	private static final String RESOURCES_BQUEEN_PNG = "bqueen.png";
	private static final String RESOURCES_WQUEEN_PNG = "wqueen.png";
	private static final String RESOURCES_WPAWN_PNG = "wpawn.png";
	private static final String RESOURCES_BPAWN_PNG = "bpawn.png";
    private static final String RESOURCES_WMAGICIAN_PNG = "whiteMagician.jpg";
	private static final String RESOURCES_BMAGICIAN_PNG = "blackMagician.jpg";
	
	// Logical and graphical representations of board
	private final Square[][] board;
    private final GameWindow g;
 
    //contains true if it's white's turn.
    private boolean whiteTurn;

    //if the player is currently dragging a piece this variable contains it.
    private Piece currPiece;
    private Square fromMoveSquare;
    
    //used to keep track of the x/y coordinates of the mouse.
    private int currX;
    private int currY;
    
    private Piece previousPiece;
    private int turnCount;
    private boolean kingColor;
    
    public Board(GameWindow g) {
        turnCount = 0;
        this.g = g;
        board = new Square[8][8];
        setLayout(new GridLayout(8, 8, 0, 0));

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        //TO BE IMPLEMENTED FIRST
     
      //for (.....)  
//        	populate the board with squares here. Note that the board is composed of 64 squares alternating from 
//        	white to black.
        boolean color = true;
        for(int i = 0; i < board.length; i++){ //loops through rows
            color = !color; //alternates color 
            for(int z = 0; z < board.length; z++){ //loops through columns
                color = !color; //alternates color
                board[i][z]= new Square(this, color, i,z);
                this.add(board[i][z]); 
            }
        }
        
        initializePieces();

        this.setPreferredSize(new Dimension(400, 400));
        this.setMaximumSize(new Dimension(400, 400));
        this.setMinimumSize(this.getPreferredSize());
        this.setSize(new Dimension(400, 400));

        whiteTurn = true;

    }

    //getter for previous moves
    public Piece getPreviousPiece() {
        return previousPiece;
    }

    //getter for turn count
    public int getTurnCount(){
        return turnCount;
    }

    
	//set up the board such that the black pieces are on one side and the white pieces are on the other.
	//since we only have one kind of piece for now you need only set the same number of pieces on either side.
	//it's up to you how you wish to arrange your pieces.
    private void initializePieces() {
        board[0][0].put(new Rook(true, RESOURCES_WROOK_PNG));
        board[0][1].put(new Knight(true, RESOURCES_WKNIGHT_PNG));
        board[0][2].put(new Bishop(true, RESOURCES_WBISHOP_PNG));
        board[0][3].put(new King(true, RESOURCES_WKING_PNG));
        board[0][4].put(new Queen(true, RESOURCES_WQUEEN_PNG));
        board[0][5].put(new Bishop(true, RESOURCES_WBISHOP_PNG));
        board[0][6].put(new Knight(true, RESOURCES_WKNIGHT_PNG));
        board[0][7].put(new Rook(true, RESOURCES_WROOK_PNG));
        board[1][0].put(new Magician(this, true, RESOURCES_WMAGICIAN_PNG));
        board[1][1].put(new Pawn(true, RESOURCES_WPAWN_PNG));
    	board[1][2].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[1][3].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[1][4].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[1][5].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[1][6].put(new Pawn(true, RESOURCES_WPAWN_PNG));
        board[1][7].put(new Magician(this, true, RESOURCES_WMAGICIAN_PNG));

        board[7][0].put(new Rook(false, RESOURCES_BROOK_PNG));
        board[7][1].put(new Knight(false, RESOURCES_BKNIGHT_PNG));
        board[7][2].put(new Bishop(false, RESOURCES_BBISHOP_PNG));
        board[7][3].put(new King(false, RESOURCES_BKING_PNG));
        board[7][4].put(new Queen(false, RESOURCES_BQUEEN_PNG));
        board[7][5].put(new Bishop(false, RESOURCES_BBISHOP_PNG));
        board[7][6].put(new Knight(false, RESOURCES_BKNIGHT_PNG));
        board[7][7].put(new Rook(false, RESOURCES_BROOK_PNG));
        board[6][0].put(new Magician(this, false, RESOURCES_BMAGICIAN_PNG));
        board[6][1].put(new Pawn(false, RESOURCES_BPAWN_PNG));
    	board[6][2].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[6][3].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[6][4].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[6][5].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[6][6].put(new Pawn(false, RESOURCES_BPAWN_PNG));
        board[6][7].put(new Magician(this, false, RESOURCES_BMAGICIAN_PNG));
    }
    

    public Square[][] getSquareArray() {
        return this.board;
    }

    public boolean getTurn() {
        return whiteTurn;
    }

    public void setCurrPiece(Piece p) {
        this.currPiece = p;
    }

    public Piece getCurrPiece() {
        return this.currPiece;
    }

    //precondition - the board is initialized and contains a king of either color. 
    //The boolean kingColor corresponds to the color of the king we wish to know the status of.
    //postcondition - returns true of the king is in check and false otherwise.
    public boolean isInCheck(boolean kingColor){
        boolean check = false;
        for(int i = 0; i < board.length; i++){ //loops through rows
            for(int z = 0; z < board[i].length; z++){ //loops through columns
                if(board[i][z].isOccupied() && !board[i][z].getOccupyingPiece().getColor() == kingColor){
                    if(board[i][z].getOccupyingPiece().getControlledSquares(board, board[i][z])!= null){
                    for(Square s: board[i][z].getOccupyingPiece().getControlledSquares(board, board[i][z])){
                        if(s.getOccupyingPiece() instanceof King && s.getOccupyingPiece().getColor() == kingColor){
                            return true;
                        }
                    }
                }
                }
            }
        }
        return false;
    }
        
    
    @Override
    public void paintComponent(Graphics g) {
     
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Square sq = board[x][y];
                if(sq == fromMoveSquare)
                	 sq.setBorder(BorderFactory.createLineBorder(Color.blue));
                sq.paintComponent(g);
                
            }
        }
    	if (currPiece != null) {
            if ((currPiece.getColor() && whiteTurn)
                    || (!currPiece.getColor()&& !whiteTurn)) {
                final Image img = currPiece.getImage();
                g.drawImage(img.getScaledInstance(50, 50, 0), currX, currY, null);
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        currX = e.getX();
        currY = e.getY();

        Square sq = (Square) this.getComponentAt(new Point(e.getX(), e.getY()));
        
        if (sq.isOccupied() && sq != null) {
            currPiece = sq.getOccupyingPiece();
            fromMoveSquare = sq;
            if (currPiece.getColor() != whiteTurn){
                currPiece = null;
                fromMoveSquare = null;
                return;
            }
            if (currPiece.getColor() && !whiteTurn){
                return;
            }
            sq.setDisplay(false);
        }
        else{
        }
        repaint();
    }

    //TO BE IMPLEMENTED!
    //should move the piece to the desired location only if this is a legal move.
    //use the pieces "legal move" function to determine if this move is legal, then complete it by
    //moving the new piece to it's new board location. 
    @Override
    public void mouseReleased(MouseEvent e) {
        Square endSquare = (Square) this.getComponentAt(new Point(e.getX(), e.getY()));
        if(endSquare != null && currPiece != null){
            for(Square i: currPiece.getLegalMoves(this, fromMoveSquare)){
                if(endSquare == i){
                    endSquare.put(currPiece);
                    fromMoveSquare.removePiece();
                    if(isInCheck(whiteTurn)){
                        fromMoveSquare.put(currPiece);
                        endSquare.removePiece();
                        break;
                    }
                    else{
                        previousPiece = currPiece; //sets previous piece for the magician to use later on
                        whiteTurn = !whiteTurn; //switches turn
                        turnCount++;
                        break;
                    }
                }
            }
        }
   
        
        for(Square [] row: board) {
        	for(Square s: row) {
        		s.setBorder(null);
        	}	
        }
        if(fromMoveSquare != null){
            fromMoveSquare.setDisplay(true);
        }
        currPiece = null;
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        currX = e.getX() - 24;
        currY = e.getY() - 24;

        if(currPiece!= null) {
        	for(Square s: currPiece.getLegalMoves(this, fromMoveSquare)) {
        		s.setBorder(BorderFactory.createLineBorder(Color.MAGENTA));
        	}
        	
        }
        
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}