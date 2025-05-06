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
public class Rook extends Piece {
    final Movement movement = new Movement(-1, -1, -1, 0);
    public Rook() {}
    public Rook(Player player) {
        super(player);
    }
}
