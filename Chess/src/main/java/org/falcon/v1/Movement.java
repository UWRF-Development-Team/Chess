package org.falcon.v1;

public class Movement {
    int forward;
    int backward;
    int horizontal;
    int diagonal;
    boolean isHorse;
    public Movement(int forward, int backward, int horizontal, int diagonal, boolean isHorse) {
        this.forward = forward;
        this.backward = backward;
        this.horizontal = horizontal;
        this.diagonal = diagonal;
        this.isHorse = isHorse;
    }
    public boolean isValidMovement(BoardSpot start, BoardSpot end) {
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        if (this.diagonal != 0) {
            boolean moveIsDiagonal = this.isDiagonal(start, end);
            if (moveIsDiagonal) {
                if (this.diagonal == -1 || this.diagonal <= rowDifference) {
                    return true;
                }
            }
        }
        if (this.horizontal != 0 && this.forward != 0 && this.backward != 0) {
            boolean moveIsStraight = this.isStraight(start, end);
            if (moveIsStraight) {
                if (this.horizontal == -1 || this.horizontal <= colDifference) {
                    return true;
                } else if (this.forward == -1 || this.forward <= rowDifference ||
                        this.backward == -1 || this.backward <= rowDifference) {
                    return true;
                }
            }
        }
        if (this.isHorse) {
            int combinedDifference = rowDifference + colDifference;
            if (rowDifference != 0 && colDifference != 0 && combinedDifference == 3) {
                return true;
            }
        }
        return false;
    }
    public boolean isDiagonal(BoardSpot start, BoardSpot end) {
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        if (rowDifference == 0 || colDifference == 0) {
            return false;
        } else {
            return true;
        }
    }
    public boolean isStraight(BoardSpot start, BoardSpot end) {
        return !this.isDiagonal(start, end);
    }
    /*
    Pawn: 1, 0, 0, 0
    Rook: -1, -1, -1, 0
    King: 1, 1, 1, 1
    Queen: -1, -1, -1, -1
    Bishop: 0, 0, 0, -1
     */
}
