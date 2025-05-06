package org.falcon.model.player;

public enum GameStatus {
    ONGOING("ongoing"),
    WIN("win"),
    LOSS("loss"),
    REPETITION("draw by threefold repetition"),
    AGREEMENT("draw by agreement"),
    MATERIAL("draw by lack of material"),
    STALEMATE("draw by stalemate"),
    FIFTY_MOVES("draw by fifty moves");

    public final String gameStatus;
    GameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }
}
