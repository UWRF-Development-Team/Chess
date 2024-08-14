package org.falcon.model.player;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.*;

import java.util.*;


@Getter
@Setter
public class Player {
    //    private String name;
//    private Double time;
//    private String color;
    private List<Piece> pieces;
    private PlayerChar playerChar;
    public Player(PlayerChar playerChar) {
        this.playerChar = playerChar;
        this.pieces = this.getInitialPieces();
    }
    public List<Piece> getInitialPieces() {
        List<Piece> pieces = new ArrayList<>();
        final PieceChar[][] startingPieces = {
                {PieceChar.ROOK, PieceChar.HORSE, PieceChar.BISHOP, PieceChar.QUEEN, PieceChar.KING, PieceChar.BISHOP, PieceChar.HORSE, PieceChar.ROOK},
                {PieceChar.PAWN, PieceChar.PAWN,  PieceChar.PAWN,   PieceChar.PAWN,  PieceChar.PAWN, PieceChar.PAWN,   PieceChar.PAWN,  PieceChar.PAWN}
        };
        for (int rowIndex = 0; rowIndex < 8; rowIndex++) {
            for (int colIndex = 0; colIndex < 8; colIndex++) {
                BoardSpot spot = new BoardSpot(rowIndex + 1, colIndex + 1);
                PieceChar pieceChar = startingPieces[rowIndex][colIndex];
                Piece piece = switch (pieceChar) {
                    case PAWN -> new Pawn(this);
                    case ROOK -> new Rook();
                    case HORSE -> new Horse();
                    case BISHOP -> new Bishop();
                    case KING -> new King();
                    case QUEEN -> new Queen();
                    case EMPTY -> null;
                };
                if (piece != null) {
                    pieces.add(piece);
                }
            }
        }
    }
}
