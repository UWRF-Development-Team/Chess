package org.falcon.v1;

public class Movement {
    int forward;
    int backward;
    int horizontal;
    int diagonal;
    public Movement(int forward, int backward, int horizontal, int diagonal) {
        this.forward = forward;
        this.backward = backward;
        this.horizontal = horizontal;
        this.diagonal = diagonal;
    }
    /*
    Pawn: 1, 0, 0, 0
    Rook: -1, -1, -1, 0
    King: 1, 1, 1, 1
    Queen: -1, -1, -1, -1
    Bishop: 0, 0, 0, -1
     */
}
