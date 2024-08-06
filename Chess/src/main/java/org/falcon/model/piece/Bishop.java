package org.falcon.model.piece;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.piece.movement.Movement;

@Getter
@Setter
public class Bishop extends Piece {
    private final Movement movement = new Movement(0, 0, -1, -1);
}
