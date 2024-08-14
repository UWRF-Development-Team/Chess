package org.falcon.model.player;

public enum PlayerChar {
    WHITE('W'),
    BLACK('B');
    public final char PLAYER_CHAR;
    PlayerChar(char PLAYER_CHAR) {
        this.PLAYER_CHAR = PLAYER_CHAR;
    }
}
