package org.falcon.model.piece;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.piece.movement.SpecialMovement;

@Getter
@Setter
public class Horse extends Piece {
    final SpecialMovement movement = new SpecialMovement(3, 3, 3, 3, this);
}
