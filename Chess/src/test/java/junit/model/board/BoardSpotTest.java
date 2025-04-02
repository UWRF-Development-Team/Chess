package junit.model.board;


import org.falcon.model.board.BoardSpot;
import org.junit.jupiter.api.Test;

public class BoardSpotTest {
    @Test
    public void testGetDiagonalSpot() {
        BoardSpot originalSpot = new BoardSpot(3, 3);
        BoardSpot topLeftValid = new BoardSpot(2, 2);
        BoardSpot topRightValid = new BoardSpot(2, 4);
        BoardSpot bottomLeftValid = new BoardSpot(4, 2);
        BoardSpot bottomRightValid = new BoardSpot(4, 4);
    }
}
