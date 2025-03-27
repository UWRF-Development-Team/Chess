package org.falcon.model.player;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.*;

import java.util.*;


@Getter
@Setter
public class Player {
    private PlayerChar playerChar;
    private PieceCollection pieceCollection;
    private boolean TurnStatus = false;
    public Player(PlayerChar playerChar) {
        this.playerChar = playerChar;
        this.pieceCollection = new PieceCollection(this);
    }
    public Player(PlayerChar playerChar, PieceCollection pieceCollection) {
        this.playerChar = playerChar;
        this.pieceCollection = pieceCollection;
    }

}
