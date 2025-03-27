package org.falcon.model.piece;

import lombok.Getter;
import lombok.Setter;
import org.falcon.model.piece.member.*;
import org.falcon.model.player.Player;
import org.falcon.model.player.PlayerChar;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class PieceCollection {
    public static final PieceChar[][] BLACK_STARTING_PIECES = {
            {PieceChar.ROOK, PieceChar.HORSE, PieceChar.BISHOP, PieceChar.QUEEN, PieceChar.KING, PieceChar.BISHOP, PieceChar.HORSE, PieceChar.ROOK},
            {PieceChar.PAWN, PieceChar.PAWN,  PieceChar.PAWN,   PieceChar.PAWN,  PieceChar.PAWN, PieceChar.PAWN,   PieceChar.PAWN,  PieceChar.PAWN}
    };
    public static final PieceChar[][] WHITE_STARTING_PIECES = {
            {PieceChar.PAWN, PieceChar.PAWN,  PieceChar.PAWN,   PieceChar.PAWN,  PieceChar.PAWN, PieceChar.PAWN,   PieceChar.PAWN,  PieceChar.PAWN},
            {PieceChar.ROOK, PieceChar.HORSE, PieceChar.BISHOP, PieceChar.KING,  PieceChar.QUEEN, PieceChar.BISHOP, PieceChar.HORSE, PieceChar.ROOK}
    };
    private Player player;
    private List<Piece> pieces;
    // Constructor
    public PieceCollection(Player player) {
        this.player = player;
        this.pieces = this.getInitialPieces();
    }
    public PieceCollection(Player player, List<Piece> pieces) {
        this.player = player;
        this.pieces = pieces;
    }

    public PieceOrientation getPieceOrientation() {
        if(this.player.getPlayerChar() == PlayerChar.WHITE) {
           return PieceOrientation.BOTTOM;
        }
        else {
            return PieceOrientation.TOP;
        }
    }
    public List<Piece> getInitialPieces() {
        List<Piece> pieces = new ArrayList<>();
        // Alternatives like predefined members and counts can be put into
        // an enum.
        PieceChar[][] startingPieces = switch (this.player.getPlayerChar()) {
            case BLACK -> BLACK_STARTING_PIECES;
            case WHITE -> WHITE_STARTING_PIECES;
        };
        for (int rowIndex = 0; rowIndex < 8; rowIndex++) {
            for (int colIndex = 0; colIndex < 8; colIndex++) {
                PieceChar pieceChar = startingPieces[rowIndex][colIndex];
                Piece piece = switch (pieceChar) {
                    case PAWN -> new Pawn(this.player, this.getPieceOrientation());
                    case ROOK -> new Rook(this.player);
                    case HORSE -> new Horse(this.player);
                    case BISHOP -> new Bishop(this.player);
                    case KING -> new King(this.player);
                    case QUEEN -> new Queen(this.player);
                    case EMPTY -> null;
                };
                if (piece != null) {
                    pieces.add(piece);
                }
            }
        }
        return pieces;
    }
}
