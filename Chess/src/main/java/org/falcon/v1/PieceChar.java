package org.falcon.v1;

public enum PieceChar {
    PAWN('P'),
    ROOK('R'),
    HORSE('H'),
    BISHOP('B'),
    KING('K'),
    QUEEN('Q'),
    EMPTY(' ');
    final char pieceChar;
    PieceChar(char pieceChar) {
        this.pieceChar = pieceChar;
    }
    public char getPieceChar() {
        return this.pieceChar;
    }
}
