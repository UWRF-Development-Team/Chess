package org.falcon.comm.response;

import lombok.Data;
import org.falcon.model.chess.Chess;

@Data
public class ChessResponse {
    private Chess chess;
    public ChessResponse(Chess chess) {
        this.chess = chess;
    }
}
