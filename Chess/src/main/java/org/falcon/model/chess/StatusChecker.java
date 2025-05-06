package org.falcon.model.chess;
import org.falcon.model.board.Board;
import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.PieceCollection;
public class StatusChecker {
    private Turn turnNum = new Turn();
    private int storedTurnNum = 0;

    public String checkIfDrawByLackOfMaterial(){
        //check for both players
        if(NoQUEENS,PAWNS,ROOKS){
            if(only bishop and king/only_knights and king/only_king){
                return "draw by lack of material";
            }
        }
    }
    public String checkIfDrawByAgreement(){
        // add boolean to agree to draw in turn class
        if (player1.agreeToDraw == true && player2.agreeToDraw){
            return "draw by agreement";
        }
    }
    public String checkIf50Moves(){
        //pseudocode to remember event we are checking for
        if(pawnMoves){
            storedTurnNum = turnNum.getTurnCount();
        }
        if(captureOccurs){
            storedTurnNum = turnNum.getTurnCount();
        }
        if(turnNum.getTurnCount() - storedTurnNum >= 100){
            return "draw by fifty moves";
        }
        return "ongoing";
    }
}

// Result in draw by lack of material (I think maybe).
//King vs King (no other pieces)
//
//King and Bishop vs King
//
//King and Knight vs King
//
//King and Bishop vs King and Bishop (if both bishops are on the same color squares)
