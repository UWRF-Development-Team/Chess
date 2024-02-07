package tests;

import org.falcon.v1.Board;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BoardTestV2 {
        Board testDefaultBoard = new Board();
    /*
-----------------
|R|H|B|Q|K|B|H|R|
|P|P|P|P|P|P|P|P|
| | | | | | | | |
| | | | | | | | |
| | | | | | | | |
| | | | | | | | |
|P|P|P|P|P|P|P|P|
|R|H|B|K|Q|B|H|R|
-----------------
 */
    @Test
    public void testDefaultBoard() {
        char[][] expectedBoard = {
                {'R', 'H', 'B', 'K', 'Q', 'B', 'H', 'R'},
                {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
                {'R', 'H', 'B', 'K', 'Q', 'B', 'H', 'R'}
        };
        char[][] actualBoard = this.testDefaultBoard.getBoard();
        boolean boardsEqual = Arrays.deepEquals(expectedBoard, actualBoard);
        assertTrue(boardsEqual);
    }
}
