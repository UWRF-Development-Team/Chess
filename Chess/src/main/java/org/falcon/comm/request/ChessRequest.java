package org.falcon.comm.request;

import lombok.Data;

@Data
public class ChessRequest {
    private String playerOneUsername;
    private String playerTwoUsername;
    public ChessRequest(String playerOneUsername, String playerTwoUsername) {
        this.playerOneUsername = playerOneUsername;
        this.playerTwoUsername = playerTwoUsername;
    }
}
