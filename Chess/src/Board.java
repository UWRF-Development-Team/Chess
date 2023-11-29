import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Board {
    //-----------------------------Class-Variables----------------------------

    //---------------------------------Capture--------------------------------
    public void capture(Piece capturedPiece) {

    }
    //------------------------------Piece-At----------------------------------
    public Optional<?> pieceAt(int rowIndex, int colIndex) {
        return null;
    }
    //---------------------------Valid-Placement------------------------------
    public boolean validPlacement(int rowIndex, int colIndex) {
        // Parent function which will call all the helper functions to
        // validate the move.
        return false;
    }
    //-----------------------------In-Bounds----------------------------------
    public boolean inBounds(int rowIndex, int colIndex) {
        if (rowIndex < 0 || rowIndex > 7 || colIndex < 0 || colIndex > 7) {
            return false;
        } else {
            return true;
        }
    }
    //---------------------------Violates-Check-------------------------------
    public boolean violatesCheck(int rowIndex, int colIndex) {
        return false;
    }
    //------------------------------Is-Blocked--------------------------------
    public boolean isBlocked(int rowIndex, int colIndex) {
        // if (pieceAt(rowIndex, colIndex) instanceof Horse)
        /*
        switch (piece) {
            instanceof Bishop -> {
                // check diagonal sides
            }
            instanceof Rook -> {
                // check up/down sides
            }
        }
         */
        return false;
    }
}


