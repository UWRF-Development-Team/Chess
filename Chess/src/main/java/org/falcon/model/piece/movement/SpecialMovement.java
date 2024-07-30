package org.falcon.model.piece.movement;

import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.PieceChar;

public class SpecialMovement extends Movement {
    private PieceChar pieceChar;
    public SpecialMovement(int forward, int backward, int horizontal, int diagonal, PieceChar pieceChar) {
        super(forward, backward, horizontal, diagonal);
        this.pieceChar = pieceChar;
    }
    public boolean isHorse() {
        return this.pieceChar.PIECE_CHAR == PieceChar.HORSE.PIECE_CHAR;
    }
    @Override
    public boolean isValidMovement(BoardSpot start, BoardSpot end) {
        if (!this.isHorse()) {
            return super.isValidMovement(start, end);
        }
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        int combinedDifference = rowDifference + colDifference;
        if (rowDifference != 0 && colDifference != 0 && combinedDifference == 3) {
            if (rowDifference == 1 && colDifference == 2) {
                return true;
            } else if (rowDifference == 2 && colDifference == 1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public boolean isForward(int value) {
        return value >= 0;
    }
    public boolean isValidMovement(BoardSpot start, BoardSpot end, boolean isFirstMove) {
        int rowDifferenceRaw = end.getRow() - start.getRow();
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        boolean isDiagonal = isDiagonal(start, end);
        if (isFirstMove) {

            if ((rowDifference <= 2 && this.isForward(rowDifferenceRaw)) || !isDiagonal) {
                return true;
            } else {
                return false;
            }
        } else {
            this.setDiagonal(1);
            this.setForward(1);
            return super.isValidMovement(start, end);
        }
    }
}
