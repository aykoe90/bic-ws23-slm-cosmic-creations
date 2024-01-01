package org.example;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear(); // clear Methode, um das Brett zu initialisieren.
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == '\u0000'; // Unicode Null Zeichen, bedeutet leere Zelle
    }

    public void place(int x, int y, char marker) {
        if (isCellEmpty(x, y)) {
            cells[x][y] = marker;
        }
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == '\u0000') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '\u0000';
            }
        }
    }

    public void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + (cells[i][j] == '\u0000' ? " " : cells[i][j]));
            }
            System.out.println("|");
        }
    }
    public char getCell(int x, int y) {
        return cells[x][y];
    }

}