package org.falcon.v1;

public abstract class Piece {
    Piece() {
        
    }
    public abstract void losePiece();
    public abstract void promotePiece();
    public abstract void makeMove(int rowIndex, int colIndex);
    public abstract boolean validMove(int rowIndex, int colIndex);
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

