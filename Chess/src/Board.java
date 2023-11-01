import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Board {
    //-----------------------------Class-Variables------------------------------
    private String color;
    private HashMap<Player, Integer[]> playerSides;
    private int size;
    Piece piece;
    ArrayList<Optional<?>> spots;
    //Piece?
    public Board() {
        this.spots = new ArrayList<>();
    }
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        //validation
        this.color = color;
    }

    public int getSides() {
        return this.sides;
    }



}


