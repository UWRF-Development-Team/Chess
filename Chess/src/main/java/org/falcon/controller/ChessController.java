package org.falcon.controller;


import org.falcon.comm.request.MoveRequest;
import org.falcon.comm.response.ChessResponse;
import org.falcon.comm.response.MoveResponse;
import org.falcon.comm.response.ValidMoveResponse;
import org.falcon.model.chess.Chess;
import org.falcon.model.user.User;
import org.falcon.service.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/chess")
public class ChessController {
    private User currentPlayer;
    private ChessService chessService;
    private Chess currentGame;
    public ChessController(ChessService chessService) {
        this.currentPlayer = null;
        this.chessService = chessService;
        this.currentGame = null;
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ChessResponse> getById(@RequestParam Long id) {
        Optional<Chess> possibleGame = this.chessService.getById(id);
        if (possibleGame.isEmpty()) {
            return new ResponseEntity<>(new ChessResponse(null), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ChessResponse(possibleGame.get()), HttpStatus.OK);
        }
    }

    @PostMapping("/move/validate")
    public ResponseEntity<ValidMoveResponse> validateMove(@RequestBody MoveRequest moveRequest) {
        return null;
    }

    @PostMapping("/move")
    public ResponseEntity<MoveResponse> move(@RequestBody MoveRequest moveRequest) {
        return null;
    }
}
