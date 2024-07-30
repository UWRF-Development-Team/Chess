package junit.model.piece.movement;

import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.King;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MovementTest {
    @Test
    public void testIsValidMovementKing() {
        King king = new King();
        boolean actualIsValidMovement = king.MOVEMENT.isValidMovement(new BoardSpot(1,1), new BoardSpot(2,2));
        assertTrue(actualIsValidMovement);
        actualIsValidMovement = king.MOVEMENT.isValidMovement(new BoardSpot(1,1), new BoardSpot(3,3));
        assertFalse(actualIsValidMovement); // TODO: Fix movement, currently fails
    }
}
