package org.falcon.v1;

import java.util.ArrayList;

public abstract class Piece {
    Movement movement;
    Piece(Movement movement) {
        this.movement = movement;
    }
    public abstract ArrayList<BoardSpot> possibleMoves();
    //public abstract void losePiece();
    //public abstract void promotePiece();
    //public abstract void makeMove(int rowIndex, int colIndex);
    //public abstract boolean validMove(int rowIndex, int colIndex);
    // Type
    // Chess pieces
        // Queen
        // King
        // Rook
        // Bishop
        // Knight
        // Pawn
        //- pawn should have properties that allow promotion

}

