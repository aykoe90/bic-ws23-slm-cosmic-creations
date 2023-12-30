package org.example;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;
    private boolean gameOver = false;

    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1; // Spieler 1 beginnt
        board = new Board();
    }

    public void start() {
        board.print(); // Drucken Sie das leere Brett
    }

    public boolean playTurn(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false; // Ungültiger Index
        }
        if (board.isCellEmpty(x, y)) {
            board.place(x, y, currentPlayer.getMarker());
            if (hasWinner()) {
                System.out.println("Player " + currentPlayer.getMarker() + " wins!");
                gameOver = true;
            } else if (board.isFull()) {
                System.out.println("It's a draw!");
                gameOver = true;
            } else {
            switchCurrentPlayer();
            }
            return true;
        } else {
            return false; // Zelle ist nicht leer
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    boolean hasWinner() {
        // Prüfen der Reihen und Spalten auf einen Gewinner
        for (int i = 0; i < 3; i++) {
            if (!board.isCellEmpty(i, 0) &&
                    board.getCell(i, 0) == board.getCell(i, 1) &&
                    board.getCell(i, 0) == board.getCell(i, 2)) {
                return true;
            }
            if (!board.isCellEmpty(0, i) &&
                    board.getCell(0, i) == board.getCell(1, i) &&
                    board.getCell(0, i) == board.getCell(2, i)) {
                return true;
            }
        }
        // Prüfen der Diagonalen auf einen Gewinner
        if (!board.isCellEmpty(0, 0) &&
                board.getCell(0, 0) == board.getCell(1, 1) &&
                board.getCell(0, 0) == board.getCell(2, 2)) {
            return true;
        }
        if (!board.isCellEmpty(0, 2) &&
                board.getCell(0, 2) == board.getCell(1, 1) &&
                board.getCell(0, 2) == board.getCell(2, 0)) {
            return true;
        }
        return false;
    }


    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return gameOver;
    }
}
