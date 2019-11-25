package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    public static final int SIZE = 9;
    private List<SudokuElement> cols;

    public SudokuRow() {
        cols = new ArrayList<SudokuElement>();
        for (int i = 0; i < SIZE; i++) {
            cols.add(i, new SudokuElement());
        }
    }

    public List<SudokuElement> getCols() {
        return cols;
    }

}
