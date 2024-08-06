package org.falcon.model.piece.movement;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.board.BoardSpot;

@Getter
@Setter
public class Movement {
    private int forward;
    private int backward;
    private int horizontal;
    private int diagonal;

    public Movement(int forward, int backward, int horizontal, int diagonal) {
        this.forward = forward;
        this.backward = backward;
        this.horizontal = horizontal;
        this.diagonal = diagonal;
    }
    public static boolean isInfinite(int movementValue) {
        return movementValue == -1;
    }
    public static boolean isMoveable(int movementValue) {
        return movementValue != 0;
    }
    public static boolean inRange(int changeValue, int range) {
        return changeValue <= range;
    }
    public boolean isValidMovement(BoardSpot start, BoardSpot end) {
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        if (isMoveable(this.diagonal)) {
            boolean moveIsDiagonal = isDiagonal(start, end);
            if (moveIsDiagonal) {
                if (isInfinite(this.diagonal) || (inRange(rowDifference, this.diagonal) && inRange(colDifference, this.diagonal))) {
                    return true;
                }
            }
        }
        if (isMoveable(this.horizontal) && isMoveable(this.forward) && isMoveable(this.backward)) {
            boolean moveIsStraight = isStraight(start, end);
            if (moveIsStraight) {
                if (isInfinite(this.horizontal) ||  colDifference <= this.horizontal) {
                    return true;
                } else if (isInfinite(this.forward) || inRange(rowDifference, this.forward) ||
                           isInfinite(this.backward) || inRange(rowDifference, this.backward)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * isDiagonal tests whether a given move is diagonal
     * @param start - a BoardSpot which indices the initial position
     * @param end  - of type BoardSpot which indicates the destination
     * @return boolean true if the move is diagonal, false otherwise
     */

    public static boolean isDiagonal(BoardSpot start, BoardSpot end) {
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        return rowDifference != 0 && colDifference != 0;
    }
    public static boolean isStraight(BoardSpot start, BoardSpot end) {
        return !isDiagonal(start, end);
    }
    /*
    Pawn: 1, 0, 0, 0
    Rook: -1, -1, -1, 0
    King: 1, 1, 1, 1
    Queen: -1, -1, -1, -1
    Bishop: 0, 0, 0, -1
     */
}
