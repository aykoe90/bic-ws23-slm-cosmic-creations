package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        // todo Konstruktor-Logik
    }

    public boolean isCellEmpty(int x, int y) {
        // todo Überprüfung, ob Zelle leer ist
        return false;
    }

    public void place(int x, int y, char marker) {
        // todo Setzen eines Markers an der Position (x, y)
    }

    public boolean isFull() {
        // todo Überprüfung, ob das Brett voll ist
        return false;
    }

    public void clear() {
        // todo Logik zum Löschen des Bretts
    }

    public void print() {
        // todo Logik zur Ausgabe des Bretts
    }
}