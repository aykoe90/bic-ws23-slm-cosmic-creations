package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerConstructorWithX() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker(), "Player should be initialized with 'X' marker");
    }

    @Test
    void testPlayerConstructorWithO() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker(), "Player should be initialized with 'O' marker");
    }

    @Test
    void testGetMarkerX() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker(), "getMarker should return 'X'");
    }

    @Test
    void testGetMarkerO() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker(), "getMarker should return 'O'");
    }
}
