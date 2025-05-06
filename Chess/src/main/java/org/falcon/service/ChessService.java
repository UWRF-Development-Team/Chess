package org.falcon.service;

import org.falcon.comm.request.MoveRequest;
import org.falcon.model.chess.Chess;
import org.falcon.model.player.Player;
import org.falcon.repository.ChessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChessService {
    private ChessRepository chessRepository;
    private BoardService boardService;
    @Autowired
    public ChessService(ChessRepository chessRepository,
                        BoardService boardService) {
        this.chessRepository = chessRepository;
        this.boardService = boardService;
    }

    public Optional<Chess> getById(Long id) {
        return this.chessRepository.findById(id);
    }

    public Chess getByUsernames(String playerOneUsername, String playerTwoUsername) {
        // TODO: Implement this.
        return null;
    }

    public boolean isValidMove(Chess chess, Player player, MoveRequest moveRequest) {
        return false;
    }
}
