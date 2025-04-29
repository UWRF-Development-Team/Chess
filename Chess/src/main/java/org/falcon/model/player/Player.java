package org.falcon.model.player;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.falcon.model.Identifiable;
import org.falcon.model.piece.*;
import org.falcon.model.user.User;


@Getter
@Setter
@Entity
public class Player extends Identifiable {
    private PlayerChar playerChar;
    private PieceCollection pieceCollection;
    @Transient
    private User user;
    private boolean isTurn = false;
    public Player() {
        this.pieceCollection = new PieceCollection(this);
        this.user = new User();
    }
    public Player(PlayerChar playerChar) {
        this.playerChar = playerChar;
        this.pieceCollection = new PieceCollection(this);
        this.user = new User();
    }
    public Player(PlayerChar playerChar, PieceCollection pieceCollection) {
        this.playerChar = playerChar;
        this.pieceCollection = pieceCollection;
        this.user = new User();
    }

    public Player(PlayerChar playerChar, PieceCollection pieceCollection, User user) {
        this.playerChar = playerChar;
        this.pieceCollection = pieceCollection;
        this.user = new User();
    }
}
