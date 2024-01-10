package tests;

import org.falcon.v1.Board;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertFalse;

public class BoardTest {
    Board testBoard = new Board();
    @Test
    public void testDefaultBoard() {
        char[][] defaultBoard = new char[8][8];
        Arrays.stream(defaultBoard).forEach(row -> Arrays.fill(row, ' '));
        boolean areBoardsEqual = Arrays.deepEquals(defaultBoard, testBoard.getBoard());
        // defaultBoard = @char555656
        /* defaultBoard = {
            ..., ..., ..., ...
        }
         */
        assertFalse(areBoardsEqual);
    }
}
