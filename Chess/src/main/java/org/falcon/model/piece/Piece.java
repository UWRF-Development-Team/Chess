package org.falcon.model.piece;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.movement.Movement;
import org.falcon.model.player.Player;

import java.util.List;

@Getter
@Setter
public abstract class Piece {
    private final Movement movement = new Movement(0, 0, 0, 0);
    protected Player player;
    public Piece() {
        this.player = null;
    }
    public Piece(Player player) {
        this.player = player;
    }

    public boolean isEnemyPiece(Piece piece) {
        return !this.player.equals(piece.getPlayer());
    }

    // TODO: possibleMoves() should be used to light up hints for the user.

    //    public abstract List<BoardSpot> possibleMoves();
    //public abstract void losePiece();
    //public abstract void promotePiece();
    //public abstract void makeMove(int rowIndex, int colIndex);
    //public abstract boolean validMove(int rowIndex, int colIndex);
    // Type
    // Chess pieces
    // Queen
    // King
    // Rook
    // Bishop
    // Knight
    // Pawn
    //- pawn should have properties that allow promotion

}

