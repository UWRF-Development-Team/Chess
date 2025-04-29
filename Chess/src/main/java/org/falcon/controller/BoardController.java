package org.falcon.controller;

import org.falcon.comm.request.MoveRequest;
import org.falcon.comm.response.MoveResponse;
import org.falcon.model.board.Board;
import org.falcon.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/board")
public class BoardController {
    private Board currentBoard;
    private BoardService boardService;
    @Autowired
    public BoardController(Board board,
                           BoardService boardService) {
        this.currentBoard = board;
        this.boardService = boardService;
    }
    @RequestMapping("/move")
    public ResponseEntity<MoveResponse> move(@RequestBody MoveRequest moveRequest) {
        return null;
    }
}
