package org.falcon.controller;


import org.falcon.comm.request.MoveRequest;
import org.falcon.comm.response.MoveResponse;
import org.falcon.comm.response.ValidMoveResponse;
import org.falcon.model.chess.Chess;
import org.falcon.model.user.User;
import org.falcon.service.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chess")
public class ChessController {
    private User currentPlayer;
    private ChessService chessService;
    public ChessController(ChessService chessService) {
        this.currentPlayer = null;
        this.chessService = chessService;
    }
    @GetMapping("/get/{id}")
    public Chess getById(@RequestParam int id) {
        return null;
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
