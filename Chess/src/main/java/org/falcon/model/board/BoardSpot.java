package org.falcon.model.board;

import lombok.Getter;
import lombok.Setter;
import org.falcon.exception.PieceOutOfBoundsException;

@Getter
@Setter
public class BoardSpot {
    // One indexed based.
    private int row;
    private int col;
    public BoardSpot(int row, int col) {
        this.row = row;
        this.col = col;
        this.throwsOutOfBounds();
    }
    public void throwsOutOfBounds() {
        if (this.row < 1 || this.row > 8 || this.col < 1 || this.col > 8) {
            throw new PieceOutOfBoundsException();
        }
    }
    public static boolean hasMoved(BoardSpot start, BoardSpot end) {
        return start.getRow() != end.getRow() || start.getCol() != end.getCol();
    }
}
