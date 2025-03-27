package org.falcon.model.piece;

public enum PieceOrientation {
    TOP ("top"),
    BOTTOM("bottom");

    public final String orientation;
    PieceOrientation(String orientation) {
        this.orientation = orientation;
    }
}
