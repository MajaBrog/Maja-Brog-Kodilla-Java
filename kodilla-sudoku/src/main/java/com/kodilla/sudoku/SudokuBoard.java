package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {
    private List<SudokuRow> rows;
    private static final int SIZE = 9;
    private final int EMPTY = -1;

    public SudokuBoard() {
        rows = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            rows.add(i, new SudokuRow());
        }
    }

    public void resolve() {
        while (!checkIfSudokuResolved()) {
            for (int row = 0; row < SIZE; row++) {
                for (int column = 0; column < SIZE; column++) {
                    removePossiblesFromRow(row, column);
                    removePossiblesFromCol(row, column);
                    removePossiblesBox(row, column);
                }
            }
            for (int row = 0; row < SIZE; row++) {
                for (int column = 0; column < SIZE; column++) {
                    if (getElement(row, column).getValue() == EMPTY)
                        setValueIfOnlyOne(row, column);
                }
            }
        }
    }

    private void setValueIfOnlyOne(int row, int column) {
        if (getPossibles(row, column).size() == 1) {
            Integer value = getPossibles(row, column).get(0);
            setValue(row, column, value);
        }
    }

    public void setValue(int row, int column, Integer value) {
        if (possibleValue(row, column, value))
            getElement(row, column).setValue(value);
    }

    private void removePossiblesBox(int row, int column) {
        int boxX = column / 3;
        int boxY = row / 3;
        removePossiblesSelectedBox(row, column, boxX, boxY);
    }

    private void removePossiblesSelectedBox(int row, int column, int boxX, int boxY) {
        for (int dx = 0; dx < 3; dx++) {
            for (int dy = 0; dy < 3; dy++) {
                Integer value = getElement(boxY * 3 + dy, boxX * 3 + dx).getValue();
                getPossibles(row, column).remove(value);
            }
        }
    }

    private void removePossiblesFromCol(int row, int column) {
        for (int r = 0; r < SIZE; r++) {
            Integer value = getElement(r, column).getValue();
            getPossibles(row, column).remove(value);
        }
    }

    private void removePossiblesFromRow(int row, int column) {
        for (int col = 0; col < SIZE; col++) {
            Integer value = getElement(row, col).getValue();
            getPossibles(row, column).remove(value);
        }
    }

    private List<Integer> getPossibles(int row, int col) {
        return rows.get(row).getCols().get(col).getPossibleValues();
    }

    private SudokuElement getElement(int row, int col) {
        return rows.get(row).getCols().get(col);
    }

    private boolean checkIfSudokuResolved() {
        return rows.stream()
                .flatMap(n -> n.getCols().stream())
                .noneMatch(sudokuElement -> sudokuElement.getValue() == EMPTY);
    }

    private boolean possibleValue(int row, int column, Integer value) {
        return !existsInRow(row, value) && !existsInColumn(column, value) && !existsInBox(row, column, value);
    }

    private boolean existsInRow(int row, Integer value) {
        return rows.get(row).getCols().stream()
                .anyMatch(element -> element.getValue().equals(value));
    }

    private boolean existsInColumn(int column, Integer value) {
        return rows.stream()
                .map(SudokuRow::getCols)
                .anyMatch(element -> element.get(column).getValue().equals(value));
    }

    private boolean existsInBox(int row, int column, Integer value) {
        int r = row - row % 3;
        int c = column - column % 3;
        boolean existsInBox = false;
        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (getElement(i, j).getValue().equals(value)) existsInBox = true;
        return existsInBox;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("----------------------------\n");
        for (int row = 0; row < SIZE; row++) {
            s.append("|");
            for (int col = 0; col < SIZE; col++) {
                Integer value = rows.get(row).getCols().get(col).getValue();
                if (value != EMPTY)
                    s.append(" ").append(value).append("|");
                else
                    s.append("  |");
            }
            s.append("\n");
        }
        s.append("----------------------------\n");
        return s.toString();
    }

    public void sudokuDemo() {
        setValue(0, 0, 9);
        setValue(0, 1, 4);
        setValue(0, 2, 8);
        setValue(0, 3, 6);
        setValue(0, 4, 7);
        setValue(0, 5, 2);
        setValue(0, 6, 5);
        setValue(0, 7, 3);
        setValue(0, 7, 3);
        setValue(1, 1, 7);
        setValue(1, 3, 8);
        setValue(1, 5, 1);
        setValue(2, 0, 6);
        setValue(2, 1, 3);
        setValue(2, 6, 8);
        setValue(2, 7, 2);
        setValue(3, 4, 5);
        setValue(3, 5, 7);
        setValue(3, 6, 4);
        setValue(4, 0, 7);
        setValue(4, 4, 9);
        setValue(5, 2, 9);
        setValue(5, 3, 2);
        setValue(5, 4, 8);
        setValue(5, 7, 5);
        setValue(6, 2, 6);
        setValue(7, 0, 4);
        setValue(7, 2, 2);
        setValue(7, 7, 8);
        setValue(8, 5, 5);
        setValue(8, 6, 9);
    }
}
