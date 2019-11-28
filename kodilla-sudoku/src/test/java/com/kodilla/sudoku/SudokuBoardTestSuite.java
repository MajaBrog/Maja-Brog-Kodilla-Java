package com.kodilla.sudoku;

import org.junit.Test;

public class SudokuBoardTestSuite {
    @Test
    public void test() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.sudokuDemo();
        sudokuBoard.resolve();
        System.out.println(sudokuBoard);
    }


}
