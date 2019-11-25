package com.kodilla.sudoku;

import org.junit.Test;

public class SudokuBoardTestSuite {
    @Test
    public void test() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        sudokuBoard.setElementValue(1,2,3);
        sudokuBoard.setElementValue(1,1,3);
        sudokuBoard.resolve();
        System.out.println(sudokuBoard.getRows().get(1).getCols().get(1).getPossibleValues());
        System.out.println(sudokuBoard);
    }


}
