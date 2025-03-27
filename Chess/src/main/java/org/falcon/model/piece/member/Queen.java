package org.falcon.model.piece.member;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.piece.Piece;
import org.falcon.model.piece.movement.Movement;
import org.falcon.model.player.Player;

@Getter
@Setter
public class Queen extends Piece {
    final Movement movement = new Movement(-1, -1, -1, -1);
    public Queen() {}
    public Queen(Player player) {
        super(player);
    }
}
