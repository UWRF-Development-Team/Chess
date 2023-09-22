public class Main {
    // dad joke ai generator
    public static void main(String[] args) {
        System.out.println("Hello Dev Team!");
        //Randy and joe

    }
}
/*
 * board 8x8 - b&w spots (unique pathing), named spots/grid
 * players 2
 * pieces 6 unique 32 total
 
 * 1. pawn - 16
 *    - first move: forward 1 or 2
 *    - subsequent: forward 1
 *    - Capture: diagonally, by landing on piece
 *    - Promotion to any piece (excludes King)
 *      o On condition that pawn reaches opposite side of the board
 *    - En Passent (optional)
 *      o Capture pawn on condition that opponent passes your pawn without capturing
 * 2. knight - 4
 *    - Move in L-shape (2 + 1)
 *      o Move horizontal by 2, then vertical by 1
 *      o Move vertical by 2, then horizontal by 1
 *      o Can leap over other pieces
 *    - Capture: by landing on piece
 * 3. bishop - 4
 *    - moves: diagonal only
 *    - can't leap over pieces
 *    - Capture: by landing on piece
 * 4. rook (castle) - 4
 *    - Move in a straight line ( left / Right / Back / Front )
 *    - Castle: If there's no pieces in between the king and rook && it's the king's and rook's first move.
 *             Kingside Castle: King moves 2 spot to the right, and rook moves 2 spot to the left
 *             Queenside Castle: King moves 2 spot to the left, and rook moves 3 spot to the right
 *    - Capture by landing on piece
 * 5. queen - 2
 *    - move any number of spaces
 *    - Diagonal
 *    - horizontal
 *    - vertical
 * 6. king - 2
 *    -one spot in any direction
 *    -Can't move into check
 *    - Controls the win condition (checkmate, stalemate, check)
 *    - Check: If the King is able to be captured, the player must make 1 of 3 actions:
 *      1) Move the King to a spot where it is not under attack
 *      2) Block the path of the attacking piece
 *      3) Capture the checking piece
 *    - Checkmate: is the win/lose condition where the King is unable to escape "Check"
 *    - Stalemate: Is the condition where the game is drawn. There is no legal move (there is no way to capture the King and the King can constantly escape "Check")
 * 
 * move - special conditions, valid to piece, valid to board, promotion (reach the end), restrain (going over pieces)
 * turns, timer, score, capture
 * 6 terminating conditions:
 *  - 1. Checkmate
 *  - 2. Win on Timer
 *  - 3. Resignation
 *  - 4. repetition of moves
 *  - 5. stalemate
 *  - 6. draw agreement
 *
 * Hierarchy
 * Queen <- -> ^ V / \ (Left, right, up, down, diagonal up, diagonal down)
 *
 */