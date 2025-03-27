package org.falcon.model.user;
import org.falcon.model.chess.Chess;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Getter
@Setter
public class User {
    private String userName;
    private String password;
    private Chess currentGame;
    private List<Chess> gameHistory;
    private SkillLevel skillLevel;
    public User() {
        this.userName = "";
        this.password = "";
        this.currentGame = new Chess();
        this.gameHistory = new ArrayList<>();
        this.skillLevel = SkillLevel.NOVICE;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.skillLevel = SkillLevel.NOVICE;
    }
}
