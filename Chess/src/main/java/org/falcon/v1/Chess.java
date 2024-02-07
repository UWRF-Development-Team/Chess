package org.falcon.v1;

import java.util.InputMismatchException;
import java.util.Scanner;

//"controller" to collectively use other classes and perform actions
public class Chess {
    // 2 Players
    Board board;
    boolean continuePlaying;
    public Chess() {
        this.continuePlaying = true;
        this.board = new Board();
    }
    public void playGame() {
        while (this.continuePlaying) {
            this.board.printBoard();
            int row = getValidIntInput("Choose row");
            int col = getValidIntInput("Choose column");
            char piece = this.board.choosePiece();
            this.board.placePiece(row, col, piece);
            this.chooseContinuePlaying();
        }
    }
    public static int getValidIntInput(String prompt) {
        System.out.print(prompt);
        Scanner userInput = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                input = userInput.nextInt();
                validInput = true;
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a valid integer.");
                userInput.nextLine();
            }
        }
        return input;
    }
    public static PieceChar getPieceChoice() {
        System.out.println("""
                Pick a piece:
                1. Pawn
                2. Rook
                3. Horse
                4. Bishop
                5. King
                6.Queen""");
        Scanner userInput = new Scanner(System.in);
        int userChoice = 0;
        boolean validInput = false;
        PieceChar piece = null;
        while(!validInput) {
            try {
                userChoice = userInput.nextInt();
                if (userChoice >= 1 && userChoice <= 6) {
                    piece = switch (userChoice) {
                        case 1 -> PieceChar.PAWN;
                        case 2 -> PieceChar.ROOK;
                        case 3 -> PieceChar.HORSE;
                        case 4 -> PieceChar.BISHOP;
                        case 5 -> PieceChar.KING;
                        case 6 -> PieceChar.QUEEN;
                        default -> throw new IllegalStateException(("Unexpected value: " + userChoice));
                    };
                } else {
                    System.out.println("Please enter a number between 1 and 6.");
                }
            } catch (InputMismatchException ex) {
                System.err.println("Input an integer please.");
            }
        }
        return piece;
    }
    public void chooseContinuePlaying() {
        Scanner userInput = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            String input = userInput.nextLine();
            if (input.equals("y") || input.equals("yes")) {
                this.continuePlaying = true;
                validInput = true;
            } else if (input.equals("n") || input.equals("no")) {
                this.continuePlaying = false;
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter yes or no.");
            }
        }
    }
//    //this:
//    whitePlayer.makeMove(coordinates);
//
//    //or this:
//    Player.board.makeMove(coordinates);
    // Single Board
    // Ignore pieces
}
