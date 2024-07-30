package org.falcon.model;

import org.falcon.model.board.Board;
import org.falcon.model.board.BoardSpot;
import org.falcon.model.piece.PieceChar;

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


//    public void playGame() {
//        while (this.continuePlaying) {
//            this.board.printBoard();
//            int row = getValidIntInput("Choose row");
//            int col = getValidIntInput("Choose column");
//            char piece = this.board.choosePiece();
//            this.board.placePiece(row, col, piece);
//            this.chooseContinuePlaying();
//        }
//    }
    public void playGame() {
        while (this.continuePlaying) {
            this.board.printBoard();

            this.board.moveForward(this.getSpot());
            this.chooseContinuePlaying();
        }
    }

    public BoardSpot getSpot() {
        boolean isValidSpot = false;
        int row = 0;
        int col = 0;
        while (!isValidSpot) {
            row = this.getCoordinate("Enter the row number (1-8): ");
            col = this.getCoordinate("Enter the column number (1-8): ");
            boolean isCoordinateEmpty = this.isCoordinateEmpty(row, col);
            if (isCoordinateEmpty) {
                isValidSpot = false;
                System.out.println("This is an empty space, try again!");
            } else {
                isValidSpot = true;
            }
        }
        return new BoardSpot(row, col);
    }
    public int getCoordinate(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        boolean isValidSpot = false;
        int coordinate = 0;
        while (!isValidSpot) {
            try {
                coordinate = input.nextInt();
                if (coordinate < 1 || coordinate > 8) {
                    isValidSpot = false;
                } else {
                    isValidSpot = true;
                }
            } catch (InputMismatchException ex) {
                throw new RuntimeException(ex);
            }
        }
        return coordinate;
    }
    // TODO: Move to board class
    public boolean isCoordinateEmpty(int row, int col) {
        BoardSpot spot = new BoardSpot(row, col);
        char pieceAtSpot = this.board.getPieceAtSpot(spot);
        if (pieceAtSpot == PieceChar.EMPTY.PIECE_CHAR) {
            return true;
        } else {
            return false;
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
        System.out.println("Do you want to continue playing? (y/n)");
        Scanner userInput = new Scanner(System.in);
        boolean validInput = false;
        while (!validInput) {
            String input = userInput.nextLine().toLowerCase();
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
