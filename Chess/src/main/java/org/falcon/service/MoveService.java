package org.falcon.service;

import org.falcon.comm.request.MoveRequest;
import org.falcon.model.board.BoardSpot;
import org.falcon.model.player.Move;
import org.falcon.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveService {
    private MoveRepository moveRepository;
    @Autowired
    public MoveService(MoveRepository moveRepository) {
        this.moveRepository = moveRepository;
    }

    public Move getMoveFromRequest(MoveRequest moveRequest) {
        BoardSpot from = new BoardSpot(moveRequest.getStartRow(), moveRequest.getStartCol());
        BoardSpot to = new BoardSpot(moveRequest.getEndRow(), moveRequest.getEndCol());
        return new Move(from, to);
    }
}
