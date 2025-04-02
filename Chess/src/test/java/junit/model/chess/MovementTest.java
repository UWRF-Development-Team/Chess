//package junit.model.chess;
//import org.falcon.model.board.BoardSpot;
//import org.falcon.model.chess.Chess;
//import org.falcon.model.piece.movement.Movement;
//import org.falcon.model.piece.member.Bishop;
//import org.falcon.model.piece.member.Pawn;
//import org.falcon.model.piece.member.King;
//import org.falcon.model.piece.member.Queen;
//import org.falcon.model.piece.member.Rook;
//import org.falcon.model.piece.member.Horse;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class MovementTest {
//
//    private Movement testMove = new Movement(0,0,0,-1);
//    private Bishop TestB = new Bishop();
//    private Pawn TestP = new Pawn();
//    private King TestK = new King();
//    private Queen TestQ = new Queen();
//    private Rook TestR = new Rook();
//    private Horse TestH = new Horse();
//
//    @Test
//    public void setTestMove(){
//        assertFalse(TestB.getMovement().isValidMovement(new BoardSpot(1,1),new BoardSpot(2,1)));
//        assertTrue(TestB.getMovement().isValidMovement(new BoardSpot(1,1),new BoardSpot(2,2)));
//
//        assertFalse(TestP.getMovement().isValidPawnMovement(new BoardSpot(1, 1), new BoardSpot(2, 2)));
//        assertTrue(TestP.getMovement().isValidPawnMovement(new BoardSpot(6, 6), new BoardSpot(5, 6)));
//// possible error for isvalid movement method
//        assertFalse(TestK.getMovement().isValidMovement(new BoardSpot(1,1),new BoardSpot(3,1)));
//        assertTrue(TestK.getMovement().isValidMovement(new BoardSpot(1,1),new BoardSpot(2,1)));
//
//        assertFalse(TestQ.getMovement().isValidMovement(new BoardSpot(1, 1), new BoardSpot(2, 3)));
//        assertTrue(TestQ.getMovement().isValidMovement(new BoardSpot(1, 1), new BoardSpot(4, 4)));
//
//        assertFalse(TestR.getMovement().isValidMovement(new BoardSpot(1,1),new BoardSpot(2,2)));
//        assertTrue(TestR.getMovement().isValidMovement(new BoardSpot(1,1),new BoardSpot(7,1)));
//
//        assertFalse(TestH.getMovement().isValidHorseMovement(new BoardSpot(1, 1), new BoardSpot(2, 2)));
//        assertTrue(TestH.getMovement().isValidHorseMovement(new BoardSpot(1, 1), new BoardSpot(3, 2)));
//    }
//
//    @Test
//    public void testPawnValidMovement() {
//        Chess chess = new Chess();
//
//    }
//}
