package org.falcon.model.piece.member;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.falcon.model.piece.Piece;
import org.falcon.model.piece.movement.SpecialMovement;
import org.falcon.model.player.Player;

@Getter
@Setter
@Entity
public class Horse extends Piece {
    final SpecialMovement movement = new SpecialMovement(3, 3, 3, 3, this);
    public Horse() {

    }
    public Horse(Player player) {
        super(player);
    }
}
