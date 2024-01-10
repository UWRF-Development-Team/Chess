package org.falcon.v1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Board {
    char[][] board;

    //-------------------------------Constructor------------------------------
    public Board() {
        this.board = new char[8][8];
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
        System.out.println(header);
        for (int rowIndex = 0; rowIndex < 8; rowIndex++) {
            System.out.println(header);
            for (int colIndex = 0; colIndex < 8; colIndex++) {
                if(colIndex == 0) {
                    // If we are at the start, there is a divider to the left.
                    System.out.println("|" + currentBoard[rowIndex][colIndex] + "|");
                } else {
                    //everything else has a divider to the right.
                    System.out.print(currentBoard[rowIndex][colIndex] + " | ");
                }
            }
        }
        System.out.println(header);
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


