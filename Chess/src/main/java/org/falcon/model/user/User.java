package org.falcon.model.user;
import jakarta.persistence.*;
import org.falcon.model.Identifiable;
import org.falcon.model.chess.Chess;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Entity
@Getter
@Setter
public class User extends Identifiable {
    private String username;
    private String password;
    private String bio;
    @Transient
    private Chess currentGame;
    private List<Chess> gameHistory;
    private int eloRating;
    private SkillLevel skillLevel;
    public User() {
        this.username = "";
        this.password = "";
        this.bio = "";
        this.currentGame = null;
        this.eloRating = 0;
        this.currentGame = new Chess();
        this.gameHistory = new ArrayList<>();
        this.skillLevel = SkillLevel.NOVICE;
    }

    public User(String userName, String password) {
        this.username = userName;
        this.password = password;
        this.skillLevel = SkillLevel.NOVICE;
    }
}
