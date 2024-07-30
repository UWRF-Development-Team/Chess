package org.falcon.model.piece;

public enum PieceChar {
    PAWN('P'),
    ROOK('R'),
    HORSE('H'),
    BISHOP('B'),
    KING('K'),
    QUEEN('Q'),
    EMPTY(' ');
    public final char PIECE_CHAR;
    PieceChar(char PIECE_CHAR) {
        this.PIECE_CHAR = PIECE_CHAR;
    }
}
