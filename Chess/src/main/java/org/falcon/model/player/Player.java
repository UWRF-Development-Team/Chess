package org.falcon.model.player;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.falcon.model.Identifiable;
import org.falcon.model.piece.*;
import org.falcon.model.user.User;


@Getter
@Setter
@Entity
@Table(name = "players")
public class Player extends Identifiable {
    @Column(name = "player_char")
    private PlayerChar playerChar;
    @Transient
    private PieceCollection pieceCollection;
    @Column(name = "game_status")
    @Enumerated(EnumType.STRING)
    private GameStatus gameStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Player() {
        this.pieceCollection = new PieceCollection(this);
        this.user = new User();
        this.gameStatus = GameStatus.ONGOING;
    }
    public Player(PlayerChar playerChar) {
        this.playerChar = playerChar;
        this.pieceCollection = new PieceCollection(this);
        this.user = new User();
        this.gameStatus = GameStatus.ONGOING;
    }
    public Player(PlayerChar playerChar, PieceCollection pieceCollection) {
        this.playerChar = playerChar;
        this.pieceCollection = pieceCollection;
        this.user = new User();
        this.gameStatus = GameStatus.ONGOING;
    }

    public Player(PlayerChar playerChar, PieceCollection pieceCollection, User user) {
        this.playerChar = playerChar;
        this.pieceCollection = pieceCollection;
        this.user = new User();
        this.gameStatus = GameStatus.ONGOING;
    }
}
