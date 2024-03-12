//package tests;
//
//import org.falcon.v1.Board;
//import org.falcon.v1.Piece;
//import org.falcon.v1.PieceOutOfBoundsException;
//import org.junit.Test;
//
//import java.util.Arrays;
//import java.util.InputMismatchException;
//import java.util.Map;
//import java.util.Scanner;
//
//import static org.junit.Assert.assertFalse;
//import static org.junit.Assert.assertTrue;
//
//public class BoardTest {
//
//    Board testKingBoard = new Board();
//    @Test
//    public void testAllKings() {
//        // Expected board = Control
//        char[][] expected = {
//                {'K', 'K', 'K', 'K', 'K', 'K', 'K', 'K'},
//                {'K', 'K', 'K', 'K', 'K', 'K', 'K', 'K'},
//                {'K', 'K', 'K', 'K', 'K', 'K', 'K', 'K'},
//                {'K', 'K', 'K', 'K', 'K', 'K', 'K', 'K'},
//                {'K', 'K', 'K', 'K', 'K', 'K', 'K', 'K'},
//                {'K', 'K', 'K', 'K', 'K', 'K', 'K', 'K'},
//                {'K', 'K', 'K', 'K', 'K', 'K', 'K', 'K'},
//                {'K', 'K', 'K', 'K', 'K', 'K', 'K', 'K'}
//        };
//        // Actual = Thing that may change
//        char[][] actual = this.testKingBoard.getBoard();
//        boolean matches = Arrays.deepEquals(actual, expected);
//        assertFalse(matches);
//    }
//    Board testBoard = new Board();
//    @Test
//    public void testZeroesBoard() {
//        char[][] defaultBoard = new char[8][8];
//        Arrays.stream(defaultBoard).forEach(row -> Arrays.fill(row, ' '));
//        boolean areBoardsEqual = Arrays.deepEquals(defaultBoard, testBoard.getBoard());
//        // defaultBoard = @char555656
//        /* defaultBoard = {
//            ..., ..., ..., ...
//        }
//         */
//        assertFalse(areBoardsEqual);
//    }
//
//
//
//
//    }
//
//    }
//
//
//
//    Board testDefaultBoard = new Board();
//    /*
//-----------------
//|R|H|B|Q|K|B|H|R|
//|P|P|P|P|P|P|P|P|
//| | | | | | | | |
//| | | | | | | | |
//| | | | | | | | |
//| | | | | | | | |
//|P|P|P|P|P|P|P|P|
//|R|H|B|K|Q|B|H|R|
//-----------------
// */
//    @Test
//    public void testDefaultBoard() {
//        char[][] expectedBoard = {
//                {'R', 'H', 'B', 'K', 'Q', 'B', 'H', 'R'},
//                {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
//                {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
//                {'R', 'H', 'B', 'K', 'Q', 'B', 'H', 'R'}
//        };
//        char[][] actualBoard = this.testDefaultBoard.getBoard();
//        boolean boardsEqual = Arrays.deepEquals(expectedBoard, actualBoard);
//        assertTrue(boardsEqual);
//    }
//}
