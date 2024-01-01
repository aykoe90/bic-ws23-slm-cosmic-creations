package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();
        boolean playAgain = true;

        while (playAgain) {
            playGame(scanner, game);

            System.out.println("Do you want to play again? (yes/no)");
            String choice = scanner.next().toLowerCase();

            if (!choice.equals("yes")) {
                playAgain = false;
            } else {
                game.getBoard().clear(); // Setze das Spielbrett zurück
                game = new TicTacToe(); // Erstelle ein neues Spielobjekt für das neue Spiel
            }
        }
        scanner.close();
    }
        public static void playGame(Scanner scanner, TicTacToe game) {
            game.start();

            while (!game.isGameOver()) {
                System.out.println("Current Player: " + game.getCurrentPlayer().getMarker());
                int row, col;
                boolean validInput;

              do {
                 System.out.println("Enter row and column (0-2): ");
                 row = scanner.nextInt();
                 col = scanner.nextInt();
                 validInput = game.playTurn(row, col);
                if (!validInput) {
                   System.out.println("Invalid move, try again.");
                }
              } while (!validInput);

            game.getBoard().print();
        }
    }
}
