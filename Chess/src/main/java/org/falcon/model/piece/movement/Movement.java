package org.falcon.model.piece.movement;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.member.King;
import org.falcon.model.player.Move;

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
        //0 is not considered within range because a piece cannot move to where it already is.
        return (changeValue <= range && changeValue != 0);
    }

    public boolean isValidMovement(Move move) {
        return this.isValidMovement(move.getFrom(), move.getTo());
    }

    // Seeing if movement is valid
    public boolean isValidMovement(BoardSpot start, BoardSpot end) {
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        // Can move diagonally.
        if (isMoveable(this.diagonal)) {
            // Is the movement diagonal?
            boolean moveIsDiagonal = isDiagonal(start, end);
            if (moveIsDiagonal) {
                // If it is diagonal, is it within their range.
                if (isInfinite(this.diagonal) || (inRange(rowDifference, this.diagonal)
                        && inRange(colDifference, this.diagonal))) {
                    return true;
                }
            }
        }
        // Can go straight
        if (isMoveable(this.horizontal) && isMoveable(this.forward) && isMoveable(this.backward)) {
            // Is the move straight?
            boolean moveIsStraight = isStraight(start, end);
            if (moveIsStraight) {
                // Is within range left or right
                if (isInfinite(this.horizontal) ||  colDifference == this.horizontal) {
                    return true;
                    // Is in range up or down
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
     * @param end  - of type, BoardSpot which indicates the destination
     * @return boolean true if the move is diagonal, false otherwise
     */

    public static boolean isDiagonal(BoardSpot start, BoardSpot end) {
        // Diagonal always moves from one row to another and one column to another
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        boolean equalRowCol = rowDifference == colDifference;
        boolean isDiagonal = rowDifference != 0 && colDifference != 0 && equalRowCol;
        System.out.println(isDiagonal);
        return isDiagonal;
    }
    public static boolean isStraight(BoardSpot start, BoardSpot end) {
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());

        boolean rowHasChanged = rowDifference != 0;
        boolean colHasChanged = colDifference != 0;

        return rowHasChanged ^ colHasChanged;
    }
    /*
    Pawn: 1, 0, 0, 0
    Rook: -1, -1, -1, 0
    King: 1, 1, 1, 1
    Queen: -1, -1, -1, -1
    Bishop: 0, 0, 0, -1
     */
    public static void main(String[] args) {
        King TestK = new King();
        System.out.println(TestK.getMovement().isValidMovement(new BoardSpot(1,1),new BoardSpot(3,1)));
    }
}
