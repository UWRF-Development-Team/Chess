package org.falcon.model.piece.member;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.piece.Piece;
import org.falcon.model.piece.movement.Movement;
import org.falcon.model.player.Player;

@Getter
@Setter
public class King extends Piece {
    final Movement movement = new Movement(1, 1, 1, 1);
    public King() {

    }
    public King(Player player) {
        super(player);
    }
}
