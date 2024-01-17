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
