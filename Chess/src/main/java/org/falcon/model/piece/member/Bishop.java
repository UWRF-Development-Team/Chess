package org.falcon.model.piece.member;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.falcon.model.piece.Piece;
import org.falcon.model.piece.movement.Movement;
import org.falcon.model.player.Player;

@Getter
@Setter
@Entity
public class Bishop extends Piece {
    private final Movement movement = new Movement(0, 0, 0, -1);
    public Bishop () {}
    public Bishop(Player player) {
        super(player);
    }
}
