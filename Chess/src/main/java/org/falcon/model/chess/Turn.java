package org.falcon.model.chess;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;
import org.falcon.model.Identifiable;
import org.falcon.model.player.Player;


@Getter
@Setter
@Entity
@Table(name = "turns")
public class Turn extends Identifiable {
    @Column(name = "turn_count")
    private int turnCount = 1;
    @Transient
    private Player playerOne;
    @Transient
    private Player playerTwo;
    
    public Turn() {
        this.playerOne = new Player();
        this.playerTwo = new Player();
    }

    public Turn(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Player getCurrentPlayer() {
        if (turnCount % 2 != 0) {
            return this.playerOne;
        } else {
            return this.playerTwo;
        }
    }

    public void incrementTurn() {
        this.turnCount++;
    }

    public Player takeTurn() {
        this.incrementTurn();
        return this.getCurrentPlayer();
    }
    
    public void resetTurnCount(){
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
