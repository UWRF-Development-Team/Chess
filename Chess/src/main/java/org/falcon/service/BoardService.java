package org.falcon.service;

import org.falcon.comm.request.MoveRequest;
import org.falcon.model.board.Board;
import org.falcon.model.chess.Chess;
import org.falcon.model.player.Player;
import org.falcon.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    private BoardRepository boardRepository;
    @Autowired
    public BoardService(BoardRepository bboardRepository) {
        this.boardRepository = bboardRepository;
    }
    public Chess makeMove(Player player,
                          Chess chess,
                          MoveRequest moveRequest) {

        return chess;
    }
}
