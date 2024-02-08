package org.falcon.v1;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Chess chess = new Chess();
        chess.playGame();
    }
}
/*

Algorithm:
Recursively loop through the array to check every available spot. Return those indices, and validate
the current users choice (row and column)

 * board 8x8 - b&w spots (unique pathing), named spots/grid
 * players 2
 * pieces 6 unique 32 total
 
 * 1. pawn - 16
 *    - first move: forward 1 or 2
 *    - subsequent: forward 1
 *    - Capture: diagonally, by landing on piece (can't capture forward)
 *    - Promotion to any piece (excludes King)
 *      o On condition that pawn reaches opposite side of the board
 *    - En Passent (optional)
 *      o Capture pawn on condition that opponent passes your pawn without capturing
 * 2. knight - 4
 *    - Move in L-shape (2 + 1)
 *      o Move horizontal by 2, then vertical by 1 or Move vertical by 2, then horizontal by 1
 *      o Only piece that can leap over other pieces (Castling is 1 exception for King and Rook)
 *    - Capture: by landing on piece
 * 3. bishop - 4
 *    - moves: diagonal only with edge of board and other pieces being the limit
 *    - Capture: by landing on piece
 * 4. rook (castle) - 4
 *    - Move in a straight line ( left / Right / Back / Front )
 *    - Castle: If there's no pieces in between the king and rook && it's the king's and rook's first move.
 *             REQUIRES THAT NEITHER OF THE PIECES HAVE MOVED (non-associated pieces do not affect this, the other rook can be previously moved as long as the rook being castles hasn't been moved during the game)
 *             Kingside Castle: King moves 2 spot to the right, and rook moves 2 spot to the left
 *             Queenside Castle: King moves 2 spot to the left, and rook moves 3 spot to the right
 *    - Capture by landing on piece
 * 5. queen - 2
 *    - move any number of spaces, limited by edge of board and other pieces
 *    - Diagonal
 *    - horizontal
 *    - vertical
 * 6. king - 2
 *    -one spot in any direction
 *    -can't move into check (some softwares make this optional, others will never allow you to move into check)
 *    - Controls the win/lose condition (checkmate, stalemate, check)
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
 * Queen <- -> ^ V / \ (Left, right, up, down, diagonal up, diagonal down) - multiple spaces - cannot jump
 * King <- -> ^ V / \ (left, right, up, down, diagonal up, diagonal down) - one space
 * Rook <- -> ^ V (Left, right, up, down) - multiple spaces - cannot jump (except castling)
 * Bishop / \ (diagonal up, diagonal down) - cannot jump
 * Knight L shape only - can jump
 * Pawn ^ (up) ... can move diagonally when capturing
 *
 *
 * Methods:
 * Lose a piece
 * Promotion a piece
 * Move
 * Return to the board a piece
 * Select promotion from graveyard
 * Whos turn
 * Validate turn
 * Switch turn
 * is taken
 * perform castling
 * is blocked (castling - if you have ever moved your King (not even if you moved it back later)
 *              or the Rook you want to castle with; or if you are in check, or would be castling
 *              across a check or into a check)
 * is check 
 * is checkmate
 * in bounds (on the board)
 *
 * Objects:
 * org.falcon.v1.Board
 *  - Space
 *  - Color
 *  - Sides
 *  - Size
 *  - Pieces
 * org.falcon.v1.Piece (6 different)
 *  - Graveyard
 *  - On org.falcon.v1.Board
 *  - Side (player)
 *  - type
 *  - Power
 * Players (2)
 *  - Turn
 *  - Time remaining
 *  - Color
 *  -
 */