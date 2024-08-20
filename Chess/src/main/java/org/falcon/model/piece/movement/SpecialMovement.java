package org.falcon.model.piece.movement;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.board.Board;
import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.member.Horse;
import org.falcon.model.piece.member.Pawn;
import org.falcon.model.piece.Piece;

@Getter
@Setter
public class SpecialMovement extends Movement {
    private Piece piece;
    private Board board; // A board may be needed to know if a pawn can move diagonally
    public SpecialMovement(int forward, int backward, int horizontal, int diagonal, Piece piece) {
        super(forward, backward, horizontal, diagonal);
        this.piece = piece;
    }
    public SpecialMovement(int forward, int backward, int horizontal, int diagonal, Piece piece, Board board) {
        super(forward, backward, horizontal, diagonal);
        this.piece = piece;
        this.board = board;
    }
    public boolean isHorse() {
        return this.piece instanceof Horse;
    }
    public boolean isPawn() {
        return this.piece instanceof Pawn;
    }
    @Override
    public boolean isValidMovement(BoardSpot start, BoardSpot end) {
//        if (!this.isHorse()) {
//            return super.isValidMovement(start, end);
//        }
        if (this.isHorse()) {
            return this.isValidHorseMovement(start, end);
        }
        if (this.isPawn()) {
            return this.isValidPawnMovement(start, end);
        }
        return false;
    }

    public boolean isValidPawnMovement(BoardSpot start, BoardSpot end) {
        this.setPawnForward();
        int rowDifference = Math.abs(start.getRow() - end.getRow());
        int colDifference = Math.abs(start.getCol() - end.getCol());
        boolean isDiagonal = isDiagonal(start, end);
        if (isDiagonal) {

        }

    }
    public void setPawnForward() {
        if (this.piece instanceof Pawn pawn) {
            if (pawn.isFirstMove()) {
                this.setForward(2);
            } else {
                this.setForward(1);
            }
        }
    }
    public boolean isValidHorseMovement(BoardSpot start, BoardSpot end) {
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
