package junit.model.chess;
import org.falcon.model.chess.Turn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TurnTest {
    //    private T
//    @Test
//            private Turn currentTurn;
//            this.currentTurn = new Turn();
//            System.out.println(currentTurn.makeTurn());
//            System.out.println(currentTurn.makeTurn());
//
//            private
    private Turn testTurn = new Turn();

    @Test
    public void testCurrentTurn() {
        testTurn.incrementTurn();
        assertTrue(testTurn.CheckIfWhiteTurn());
    }
}
