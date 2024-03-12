package org.falcon.v1;

public class PieceOutOfBoundsException extends RuntimeException {
    final static String message = "Piece out of bounds";
    public PieceOutOfBoundsException() {
        super(message);
    }
    public PieceOutOfBoundsException(String message) {
        super(message);
    }
}
