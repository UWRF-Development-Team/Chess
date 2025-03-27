//package junit.model.piece.movement;
//
//import org.falcon.model.board.BoardSpot;
//import org.falcon.model.piece.member.King;
//import org.falcon.model.piece.member.Queen;
//import org.falcon.model.piece.member.Rook;
//import org.falcon.model.piece.movement.Movement;
//import org.junit.Test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class MovementTest {
//
//    @Test
//    public void testIsValidMovement() {
//        Movement movement = new Movement(1, 1, 1, 1);
//        boolean actualIsValidMovement = movement.isValidMovement(new BoardSpot(1,1), new BoardSpot(2,2));
//        assertTrue(actualIsValidMovement);
//        actualIsValidMovement = movement.isValidMovement(new BoardSpot(1,1), new BoardSpot(3,3));
//        assertFalse(actualIsValidMovement);
//    }
//    @Test
//    public void testIsValidMovementKing() {
//        King king = new King();
//        boolean actualIsValidMovement = king.getMovement().isValidMovement(new BoardSpot(1,1), new BoardSpot(2,2));
//        assertTrue(actualIsValidMovement);
//        actualIsValidMovement = king.getMovement().isValidMovement(new BoardSpot(1,1), new BoardSpot(3,3));
//        assertFalse(actualIsValidMovement);
//    }
//    @Test
//    public void testIsValidMovementQueen() {
//        Queen queen = new Queen();
//        boolean actualIsValidMovement = queen.getMovement().isValidMovement(new BoardSpot(1,1), new BoardSpot(2,2));
//        assertTrue(actualIsValidMovement);
//    }
//    @Test
//    public void testIsValidMovementRook() {
//        Rook rook = new Rook();
//        boolean actualIsValidMovement = rook.getMovement().isValidMovement(new BoardSpot(1,1), new BoardSpot(1,8));
//        assertTrue(actualIsValidMovement);
//        actualIsValidMovement = rook.getMovement().isValidMovement(new BoardSpot(1,1), new BoardSpot(2,2));
//        assertFalse(actualIsValidMovement);
//    }
//}
