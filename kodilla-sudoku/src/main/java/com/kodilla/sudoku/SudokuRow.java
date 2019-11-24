package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    public static final int SIZE = 9;
    private List<SudokuElement> row;

    public SudokuRow() {
        row = new ArrayList<SudokuElement>();
        for (int i = 0; i < SIZE; i++) {
            row.add(i, new SudokuElement());
        }
    }

    public List<SudokuElement> getRow() {
        return row;
    }

}
