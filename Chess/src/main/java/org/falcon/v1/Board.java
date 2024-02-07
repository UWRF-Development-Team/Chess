package org.falcon.v1;

import java.util.*;

import static org.falcon.v1.PieceChar.*;

public class Board {
    char[][] board;
    final char[][] STARTING_BOARD = {
            {ROOK.getPieceChar(),HORSE.getPieceChar(),BISHOP.getPieceChar(),QUEEN.getPieceChar(),
             KING.getPieceChar(),BISHOP.getPieceChar(),HORSE.getPieceChar(),ROOK.getPieceChar()},

            {PAWN.getPieceChar(),PAWN.getPieceChar(),PAWN.getPieceChar(),PAWN.getPieceChar(),
             PAWN.getPieceChar(),PAWN.getPieceChar(),PAWN.getPieceChar(),PAWN.getPieceChar()},

            {EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),
             EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar()},

            {EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),
            EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar()},

            {EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),
            EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar()},

            {EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),
            EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar(),EMPTY.getPieceChar()},

            {PAWN.getPieceChar(),PAWN.getPieceChar(),PAWN.getPieceChar(),PAWN.getPieceChar(),
             PAWN.getPieceChar(),PAWN.getPieceChar(),PAWN.getPieceChar(),PAWN.getPieceChar()},

            {ROOK.getPieceChar(),HORSE.getPieceChar(),BISHOP.getPieceChar(),QUEEN.getPieceChar(),
             KING.getPieceChar(),BISHOP.getPieceChar(),HORSE.getPieceChar(),ROOK.getPieceChar()}
    };

    //-------------------------------Constructor------------------------------
    public Board() {
        //Arrays.stream(this.STARTING_BOARD).forEach(row -> System.out.println((Arrays.toString(row))));
        this.board = Arrays.copyOf(this.STARTING_BOARD, this.STARTING_BOARD.length);
//        this.initializeBoard();
    }

    public void initializeBoard() {
        Arrays.stream(this.board).forEach(row -> Arrays.fill(row, ' '));
    }
    //-------------------------------Print-org.falcon.v1.Board------------------------------
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
    //------------------------------org.falcon.v1.Piece-At----------------------------------
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

    public char[][] getBoard() {
        return this.board;
    }
    public void setBoard(char[][] board) {
        this.board = board;
    }
}


