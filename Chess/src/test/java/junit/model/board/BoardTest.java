package junit.model.board;

import org.falcon.model.board.Board;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class BoardTest {
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
        printCharBoard(actualBoard);
        printCharBoard(expectedBoard);
        boolean boardsEqual = Arrays.deepEquals(expectedBoard, actualBoard);
        assertTrue(boardsEqual);
    }
    public static void printCharBoard(char[][] board) {
        int numRows = board.length;
        int numCols = board[0].length;
        System.out.println("Rows: " + numRows + " Cols: " + numCols);
        for (char[] row : board) {
            System.out.println(Arrays.toString(row));
        }
    }
}
