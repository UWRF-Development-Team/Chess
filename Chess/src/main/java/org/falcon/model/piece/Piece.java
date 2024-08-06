package org.falcon.model.piece;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.movement.Movement;

import java.util.List;

@Getter
@Setter
public abstract class Piece {
    final Movement movement = new Movement(0, 0, 0, 0);
    Piece() {

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

