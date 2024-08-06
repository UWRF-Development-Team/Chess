package org.falcon.model.piece;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.piece.movement.Movement;

@Getter
@Setter
public class King extends Piece {
    final Movement movement = new Movement(1, 1, 1, 1);
    public King() {

    }
}
