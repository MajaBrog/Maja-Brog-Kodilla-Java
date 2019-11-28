package com.kodilla.sudoku;

public class SudokuGame {

    boolean resolveSudoku() {
        SudokuBoard sudokuBoard = new SudokuBoard();
        while (true) {
            System.out.println(sudokuBoard);
            UserInput userInput = UserDialog.getUserInput();
            switch (userInput.getCommand()) {
                case DEMO:
                    sudokuBoard.sudokuDemo();
                    break;
                case EXIT:
                    return false;
                case VALUE:
                    sudokuBoard.setValue(userInput.getCol(), userInput.getRow(), userInput.getValue());
                    break;
                case RESOLVE:
                    sudokuBoard.resolve();
                    System.out.println(sudokuBoard);
                    return UserDialog.newGame();
            }
        }
    }
}
