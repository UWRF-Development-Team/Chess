package org.falcon.exception;

public class PieceOutOfBoundsException extends RuntimeException {
    public final static String EXCEPTION_MESSAGE = "Piece out of bounds";
    public PieceOutOfBoundsException() {
        super(EXCEPTION_MESSAGE);
    }
    public PieceOutOfBoundsException(String EXCEPTION_MESSAGE) {
        super(EXCEPTION_MESSAGE);
    }
}
