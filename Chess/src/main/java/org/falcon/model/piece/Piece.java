package org.falcon.model.piece;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.falcon.model.Identifiable;
import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.movement.Movement;
import org.falcon.model.player.Player;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pieces")
public abstract class Piece extends Identifiable {
    @Transient
    private final Movement movement = new Movement(0, 0, 0, 0);
    @ManyToOne
    @JoinColumn(name = "player_id")
    protected Player player;

    // Constructors
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
    // TODO: Add a page for the movement rules

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

