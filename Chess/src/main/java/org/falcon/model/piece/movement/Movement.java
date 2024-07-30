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
    public boolean isValidMovement(BoardSpot start, BoardSpot end) {
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        if (this.diagonal != 0) {
            boolean moveIsDiagonal = isDiagonal(start, end);
            if (moveIsDiagonal) {
                if (isInfinite(this.diagonal) || this.diagonal <= rowDifference) {
                    return true;
                }
            }
        }
        if (isMoveable(this.horizontal) && isMoveable(this.forward) && isMoveable(this.backward)) {
            boolean moveIsStraight = isStraight(start, end);
            if (moveIsStraight) {
                if (isInfinite(this.horizontal) || this.horizontal <= colDifference) {
                    return true;
                } else if (isInfinite(this.forward) || this.forward <= rowDifference ||
                           isInfinite(this.backward) || this.backward <= rowDifference) {
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
        if (rowDifference == 0 || colDifference == 0) {
            return false;
        } else {
            return true;
        }
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
