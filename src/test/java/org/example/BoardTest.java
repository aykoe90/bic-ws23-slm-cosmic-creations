package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void testIsCellEmptyTrue() {
        assertTrue(board.isCellEmpty(0, 0), "Cell should be empty initially");
    }

    @Test
    void testIsCellEmptyFalse() {
        board.place(0, 0, 'X');
        assertFalse(board.isCellEmpty(0, 0), "Cell should not be empty after placing a marker");
    }

    @Test
    void testPlaceValidMove() {
        board.place(1, 1, 'O');
        assertEquals('O', board.getCell(1, 1), "Cell should contain 'O'");
    }

    @Test
    void testPlaceInvalidMove() {
        board.place(0, 0, 'X');
        board.place(0, 0, 'O');
        assertEquals('X', board.getCell(0, 0), "Cell should not be overwritten if already occupied");
    }

    @Test
    void testClear() {
        board.place(0, 0, 'X');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0), "Cell should be empty after clear");
    }

    @Test
    void testPrint() {
        assertDoesNotThrow(() -> board.print(), "Print should execute without throwing exceptions");
    }
    @Test
    void testIsFullTrue() {
        // Füllen des Bretts ohne Gewinner zu erzeugen
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, (i + j) % 2 == 0 ? 'X' : 'O');
            }
        }
        assertTrue(board.isFull(), "Board should be full");
    }

    @Test
    void testIsFullFalse() {
        board.place(0, 0, 'X');
        assertFalse(board.isFull(), "Board should not be full after one move");
    }
}
