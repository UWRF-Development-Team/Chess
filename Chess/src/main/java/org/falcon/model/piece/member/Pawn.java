package org.falcon.model.piece.member;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.board.Board;
import org.falcon.model.piece.Piece;
import org.falcon.model.piece.movement.SpecialMovement;
import org.falcon.model.player.Player;

@Getter
@Setter
public class Pawn extends Piece {
    private final SpecialMovement movement = new SpecialMovement(1, 0, 1, 1, this);
    private boolean firstMove;
    public Pawn() {
        this(true);
    }
    public Pawn(Player player) {
        super(player);
        this.firstMove = true;
    }
    public Pawn(boolean firstMove) {
        this.firstMove = firstMove;
    }
    public Pawn(Board board) {
        this();
        this.movement.setBoard(board);
    }
    public Pawn(boolean firstMove, Board board) {
        this(firstMove);
        this.movement.setBoard(board);
    }
}
