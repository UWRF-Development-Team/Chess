package org.falcon.v1;

public enum PieceChar {
    PAWN('P'),
    ROOK('R'),
    HORSE('H'),
    KING('K'),
    QUEEN('Q');
    final char pieceChar;
    PieceChar(char pieceChar) {
        this.pieceChar = pieceChar;
    }
    public char getPieceChar() {
        return this.pieceChar;
    }
}