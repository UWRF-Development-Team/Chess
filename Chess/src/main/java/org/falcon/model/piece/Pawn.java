package org.falcon.model.piece;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.piece.movement.Movement;
import org.falcon.model.piece.movement.SpecialMovement;

@Getter
@Setter
public class Pawn extends Piece {
    private final SpecialMovement movement = new SpecialMovement(1, 1, 1, 1, this);
}
