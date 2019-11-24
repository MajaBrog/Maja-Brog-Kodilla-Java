package com.kodilla.sudoku;

import java.util.List;

public class SudokuGame {

    boolean resolveSudoku() {
        String [] inputVector;
        SudokuBoard sudokuBoard=new SudokuBoard();
        while(true) {
            String input = UserDialog.getInput();
            if(input.equals("SUDOKU"))break;
            else {
                inputVector = input.split(",");
                int inputRow = Integer.parseInt(inputVector[0]);
                int inputColumn = Integer.parseInt(inputVector[1]);
                int inputValue = Integer.parseInt(inputVector[2]);
                sudokuBoard.setElementValue(inputRow-1, inputColumn-1, inputValue);
            }
        }
        sudokuBoard.resolve();
        return UserDialog.newGame();
    }
}
