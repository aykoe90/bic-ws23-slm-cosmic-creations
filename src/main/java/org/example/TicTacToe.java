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
        board.print(); // Drucken des leeren Bretts
    }

    public boolean playTurn(int x, int y) {
        if (x < 0 || x > 2 || y < 0 || y > 2) {
            return false; // Ungültiger Index
        }
        if (board.isCellEmpty(x, y)) {
            board.place(x, y, currentPlayer.getMarker());
                switchCurrentPlayer();
            return true;
        } else {
            return false; // Zelle ist nicht leer
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
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
