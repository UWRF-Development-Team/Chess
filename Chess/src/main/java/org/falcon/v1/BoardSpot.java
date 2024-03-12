package org.falcon.v1;

public class BoardSpot {
    int row;
    int col;
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
    public int getRow() {
        return this.row;
    }
    public int getCol() {
        return this.col;
    }
}
