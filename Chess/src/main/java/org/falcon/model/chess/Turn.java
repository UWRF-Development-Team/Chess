package org.falcon.model.chess;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class Turn {
    private int turnCount = 0;

    
    public Turn () {

    }

    public void makeTurn(){
        this.turnCount ++;



//        if(turnCount % 2 == 0){
//            whiteTurn = false;
//        }
//        else{
//            whiteTurn = true;
//        }
//        return whiteTurn;

    }
    
    public void resetTurnCount (){
        this.turnCount = 0;
    }

    public boolean CheckIfWhiteTurn (){
        boolean checkWhiteTurn = true;
        return checkWhiteTurn = !(turnCount % 2 == 0);

    }
    public boolean CheckIfBlackTurn (){
        boolean checkBlackTurn = true;
        return checkBlackTurn = turnCount % 2 == 0;
    }


}
