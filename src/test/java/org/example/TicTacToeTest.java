package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void testPlayTurnValidMove() {
        assertTrue(game.playTurn(0, 0), "playTurn should return true for a valid move");
    }

    @Test
    void testPlayTurnInvalidMove() {
        game.playTurn(0, 0); // Platzieren eines Markers
        assertFalse(game.playTurn(0, 0), "playTurn should return false for a move on an occupied cell");
    }

    @Test
    void testSwitchCurrentPlayer() {
        Player firstPlayer = game.getCurrentPlayer();
        game.playTurn(0, 0); // Erster Zug
        Player secondPlayer = game.getCurrentPlayer();
        assertNotEquals(firstPlayer, secondPlayer, "Current player should switch after a move");
    }

    @Test
    void testGetCurrentPlayer() {
        assertNotNull(game.getCurrentPlayer(), "getCurrentPlayer should not return null");
    }

    @Test
    void testIsGameOverInitiallyFalse() {
        assertFalse(game.isGameOver(), "isGameOver should initially be false");
    }

    @Test
    void testIsGameOverAfterGameEnd() {
        // Dieser Test hängt von der Implementierung der Gewinn- und Unentschieden-Logik ab.
        // Wird erst mit der zukünfitgen User Story implementiert.
        // Zum Beispiel, nachdem ein Spieler gewinnt:
        // game.playTurn(0, 0);
        // game.playTurn(1, 0);
        // game.playTurn(0, 1);
        // game.playTurn(1, 1);
        // game.playTurn(0, 2);
        // assertTrue(game.isGameOver(), "isGameOver should be true after game ends");
    }
    @Test
    void testGetBoardNotNull() {
        TicTacToe game = new TicTacToe();
        assertNotNull(game.getBoard(), "getBoard should not return null");
    }

    @Test
    void testGetBoardIsBoardInstance() {
        TicTacToe game = new TicTacToe();
        assertTrue(game.getBoard() instanceof Board, "getBoard should return an instance of Board");
    }
}
