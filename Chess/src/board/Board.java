package board;
import java.util.ArrayList;
public class Board {
    //-----------------------------Class-Variables------------------------------
    ArrayList<Space> spaces;
    String Color;
    int sides;
    int size;
    //Piece?

    public int getSpace () {
        return this.Space;
    }

    public void setSpace(Space) {
        //validation
        //eg. isValid, isTaken,CanPlayerMoveInThatDirection
        this.Space = Space;
    }

    public String getColor() {
        return this.Color;
    }

    public void setColor(Color) {
        //validation
        this.Color = Color;
    }

    public int getSides() {
        return this.sides;
    }



}


