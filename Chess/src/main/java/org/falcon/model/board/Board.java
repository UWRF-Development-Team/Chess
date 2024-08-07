package org.falcon.model.board;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.piece.Piece;
import org.falcon.model.piece.PieceChar;

import java.util.*;

import static org.falcon.model.piece.PieceChar.*;

@Getter
@Setter
public class Board {
    private char[][] board;
    static final char[][] STARTING_BOARD = {
            {ROOK.PIECE_CHAR,HORSE.PIECE_CHAR,BISHOP.PIECE_CHAR, KING.PIECE_CHAR, QUEEN.PIECE_CHAR, BISHOP.PIECE_CHAR,HORSE.PIECE_CHAR,ROOK.PIECE_CHAR},

            {PAWN.PIECE_CHAR,PAWN.PIECE_CHAR,PAWN.PIECE_CHAR,PAWN.PIECE_CHAR, PAWN.PIECE_CHAR,PAWN.PIECE_CHAR,PAWN.PIECE_CHAR,PAWN.PIECE_CHAR},

            {EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR, EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR},

            {EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR, EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR},

            {EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR, EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR},

            {EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR, EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR,EMPTY.PIECE_CHAR},

            {PAWN.PIECE_CHAR,PAWN.PIECE_CHAR,PAWN.PIECE_CHAR,PAWN.PIECE_CHAR, PAWN.PIECE_CHAR,PAWN.PIECE_CHAR,PAWN.PIECE_CHAR,PAWN.PIECE_CHAR},

            {ROOK.PIECE_CHAR,HORSE.PIECE_CHAR,BISHOP.PIECE_CHAR,KING.PIECE_CHAR,QUEEN.PIECE_CHAR,BISHOP.PIECE_CHAR,HORSE.PIECE_CHAR,ROOK.PIECE_CHAR}
    };

    //-------------------------------Constructor------------------------------
    public Board() {
        //Arrays.stream(this.STARTING_BOARD).forEach(row -> System.out.println((Arrays.toString(row))));
        this.board = Arrays.copyOf(STARTING_BOARD, STARTING_BOARD.length);
//        this.initializeBoard();
    }
    public void initializeBoard() {
        Arrays.stream(this.board).forEach(row -> Arrays.fill(row, ' '));
    }
    //-------------------------------Print-Board------------------------------
    /*
    -----------------
    |R|H|B|Q|K|B|H|R|
    |P|P|P|P|P|P|P|P|
    | | | | | | | | |
    | | | | | | | | |
    | | | | | | | | |
    | | | | | | | | |
    |P|P|P|P|P|P|P|P|
    |R|H|B|K|Q|B|H|R|
    -----------------
     */
    //row: 0-7, col: 0-7
    public void placeKing(int rowIndex, int colIndex) {
        this.board[rowIndex][colIndex] = 'K';
    }

    public void placePiece(int rowIndex, int colIndex, char piece) {
        this.board[rowIndex][colIndex] = piece;
    }
    public void placePiece(BoardSpot spot, char piece) {
        this.board[spot.getRow() - 1][spot.getCol() - 1] = piece;
    }
    public void moveForward(BoardSpot spot) {
        int forwardAmount = this.chooseForwardAmount();
        System.out.println("Moving forward...");
        char piece = this.getPieceAtSpot(spot);
        int row = spot.getRow();
        int col = spot.getCol();
        this.placePiece(spot, PieceChar.EMPTY.PIECE_CHAR);
        BoardSpot newSpot = new BoardSpot(row + forwardAmount, col);
        this.placePiece(newSpot, piece);
    }
    public int chooseForwardAmount() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Would you like to move forward 1 or 2 spaces?");
        boolean validInput = false;
        int spaceAmount = 0;
        while (!validInput) {
            try {
                spaceAmount = userInput.nextInt();
                if (spaceAmount != 1 && spaceAmount != 2) {
                    System.out.println("Please enter 1 or 2.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please try again.");
            }
        }
        return spaceAmount;
    }
    public char getPieceAtSpot(BoardSpot spot) {
        return this.board[spot.getRow() - 1][spot.getCol() - 1];
    }
    public boolean isPieceMoveBlocked(BoardSpot spot, int moveAmount) {
        int row = spot.getRow();
        int col = spot.getCol();
        if (row == 1 || moveAmount == 2) {
            return false;
        }
        return false; // TODO: Implement this
    }
    public char choosePiece() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("""
                Please select a number to choose the desired piece (:
                Pawn: 0
                Rook: 1
                Knight(horse): 2
                Bishop: 3
                King: 4
                Queen: 5
                """);
        boolean validInput = false;
        int userIntChoice = 0;
        while (!validInput) {
            try {
                userIntChoice = userInput.nextInt();
                if (userIntChoice >= 0 && userIntChoice <= 5) {
                    validInput = true;
                } else {
                    System.out.println("Please enter a number between 0 and 5.");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a valid integer.");
                userInput.nextLine();
            }
        }
        return switch (userIntChoice) {
            case 0 -> 'P'; //-> returns the value
            case 1 -> 'R';
            case 2 -> 'H';
            case 3 -> 'B';
            case 4 -> 'K';
            case 5 -> 'Q';
            default -> throw new IllegalStateException("Unexpected value: " + userIntChoice);
        };
    }
    public void printBoard() {
        // Define the pieces
        final char PAWN = 'P',
                KING = 'K',
                QUEEN = 'Q',
                ROOK = 'R',
                BISHOP = 'B',
                HORSE = 'H',
                EMPTY = ' ';
        System.out.println("Printing board");
        char[][] currentBoard = this.board;
        String header = "-".repeat(17);
        for (int rowIndex = 0; rowIndex < 8; rowIndex++) {
            System.out.println(header);
            for (int colIndex = 0; colIndex < 8; colIndex++) {
                if(colIndex == 0) {
                    // If we are at the start, there is a divider to the left.
                    System.out.print("|" + currentBoard[rowIndex][colIndex] + "|");
                } else {
                    //everything else has a divider to the right.
                    System.out.print(currentBoard[rowIndex][colIndex] + "|");
                    if(rowIndex == 7 && colIndex == 7) {
                        System.out.println();
                        System.out.println(header);
                    }
                }
            }
            System.out.println();
        }
//        System.out.println(header);
    }

    //-----------------------------Class-Variables----------------------------

    //---------------------------------Capture--------------------------------
    public void capture(Piece capturedPiece) {

    }
    //------------------------------Piece-At----------------------------------
    public Optional<?> pieceAt(int rowIndex, int colIndex) {
        return null;
    }
    //---------------------------Valid-Placement------------------------------
    public boolean validPlacement(int rowIndex, int colIndex) {
        // Parent function which will call all the helper functions to
        // validate the move.
        return false;
    }
    //-----------------------------In-Bounds----------------------------------
    public boolean inBounds(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex > 7 || colIndex < 0 || colIndex > 7) {
            return false;
        } else {
            return true;
        }
    }
    //---------------------------Violates-Check-------------------------------
    public boolean violatesCheck(int rowIndex, int colIndex) {
        return false;
    }
    //------------------------------Is-Blocked--------------------------------
    public boolean isBlocked(int rowIndex, int colIndex) {
        // if (pieceAt(rowIndex, colIndex) instanceof Horse)
        /*
        switch (piece) {
            instanceof Bishop -> {
                // check diagonal sides
            }
            instanceof Rook -> {
                // check up/down sides
            }
        }
         */
        return false;
    }
}


