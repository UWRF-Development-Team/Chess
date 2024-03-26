package org.falcon.v1;

public class SpecialMovement extends Movement {

    public SpecialMovement(int forward, int backward, int horizontal, int diagonal) {
        super(forward, backward, horizontal, diagonal, false);
    }
    @Override
    public boolean isValidMovement(BoardSpot start, BoardSpot end) {
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());

        return false;
    }
    public boolean isForward(int value) {
        return value >=0;
    }
    public boolean isValidMovement(BoardSpot start, BoardSpot end, boolean isFirstMove) {
        int rowDifferenceRaw = end.getRow() - start.getRow();
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        boolean isDiagonal = this.isDiagonal(start, end);
        if (isFirstMove) {

            if ((rowDifference <= 2 && this.isForward(rowDifferenceRaw)) || !isDiagonal) {
                return true;
            } else {
                return false;
            }
        } else {
            this.diagonal = 1;
            this.forward = 1;
            return super.isValidMovement(start, end);
        }
    }
}
