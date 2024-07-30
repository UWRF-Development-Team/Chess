package org.falcon.model.player;

import org.falcon.model.piece.Piece;

import java.util.*;

public class Player {
    private String name;
    private Double time;
    private String color;

    List<Piece> capturedPiece = new ArrayList<> ();

}
