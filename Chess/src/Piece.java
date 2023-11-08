public abstract class Piece {
    Piece(String pawnType, String color, boolean isAlive) {
        this.pawnType = pawnType;
        this.color = color;
        this.isAlive = isAlive;
    }
    public abstract void losePiece();
    public abstract void promotePiece();
    // Type
    // Chess pieces
        // Queen
        // King
        // Rook
        // Bishop
        // Knight
        // Pawn
        //- pawn should have properties that allow promotion
    boolean isGraveyard;
}

