package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SudokuBoard extends Prototype {
    private List<SudokuRow> board;
    private static final int SIZE = 9;
    private final int EMPTY = -1;
    private List<Guess> backtrack = new ArrayList<>();

    public SudokuBoard() {
        board = new ArrayList<SudokuRow>();
        for (int i = 0; i < SIZE; i++) {
            board.add(i, new SudokuRow());
        }
    }

    public void setBoard(List<SudokuRow> board) {
        this.board = board;
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    public void resolve() {
        while (!checkIfSudokuResolved()) {
            boolean valueAdded = false;
            for (int row = 0; row < SIZE; row++)
                for (int column = 0; column < SIZE; column++) {
                    SudokuElement element = board.get(row).getRow().get(column);
                    if (element.getValue() == EMPTY) {
                        if (element.getPossibleValues().size() != 1) {
                            for (int value : element.getPossibleValues()) {
                                if (!possibleValue(row, column, value)) element.removeValue(value);
                                else if (!possibleInAnotherElement(row, column, value)) {
                                    setElementValue(row, column, value);
                                    valueAdded = true;
                                }
                            }
                        } else {
                            if (possibleValue(row, column, element.getPossibleValues().get(0))) {
                                setElementValue(row, column, element.getPossibleValues().get(0));
                                valueAdded = true;
                            } else {
                                //błąd
                                if (backtrack.size() > 0) {
                                    Guess lastBacktrack = backtrack.get(backtrack.size() - 1);
                                    int guessedRow = lastBacktrack.getRow();
                                    int guessedColumn = lastBacktrack.getColumn();
                                    int guessedValue = lastBacktrack.getValue();
                                    setBoard(lastBacktrack.getSudokuBoard().getBoard());
                                    board.get(guessedRow).getRow().get(guessedColumn).getPossibleValues().remove(guessedValue);
                                } else System.out.println("Sudoku cannot be resolved!");

                            }
                        }
                    }
                }
            if (!valueAdded) {
                guessValue();
            }
            if (!checkIfResolvable()) {
                if (backtrack.size() > 0) {
                    setBoard(backtrack.get(backtrack.size() - 1).getSudokuBoard().getBoard());

                }
            }
        }
    }

    public boolean checkIfResolvable() {
        boolean resolvableSudoku = true;
        List<SudokuElement> elementWithoutSolution = board.stream()
                .flatMap(n -> n.getRow().stream())
                .filter(sudokuElement -> sudokuElement.getValue() == -1)
                .filter(sudokuElement -> sudokuElement.getPossibleValues().size() != 0)
                .collect(Collectors.toList());
        if (elementWithoutSolution.size() > 0) {
            resolvableSudoku = false;
        }
        return resolvableSudoku;
    }

    public void guessValue() {
        Random random = new Random();
        //                List<SudokuElement> emptyElements=board.stream()
//                        .flatMap(n -> n.getRow().stream())
//                        .filter(sudokuElement -> sudokuElement.getValue()==-1)
//                        .collect(Collectors.toList());
//                SudokuElement randomElement=emptyElements.get(random.nextInt(emptyElements.size()));
//                List<Integer> possibleValues=randomElement.getPossibleValue();
//                int randomValue=possibleValues.get(random.nextInt(possibleValues.size()));

        boolean empty = false;
        SudokuElement randomElement = null;
        int randomRow = 10;
        int randomColumn = 10;
        while (!empty) {
            randomRow = random.nextInt(SIZE);
            randomColumn = random.nextInt(SIZE);
            randomElement = board.get(randomRow).getRow().get(randomColumn);
            if (randomElement.getValue() == EMPTY) empty = true;
        }

        List<Integer> possibleValues = randomElement.getPossibleValues();
        int randomValue = possibleValues.get(random.nextInt(possibleValues.size()));

        SudokuBoard clonedBoard = null;
        try {
            clonedBoard = deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Guess guess = new Guess(clonedBoard, randomRow, randomColumn, randomValue);
        backtrack.add(backtrack.size() + 1, guess);
        randomElement.setValue(randomValue);
    }


    public SudokuBoard deepCopy() throws CloneNotSupportedException {
        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.board = new ArrayList<>();
        for (SudokuRow rows : board) {
            SudokuRow clonedRow = new SudokuRow();
            for (SudokuElement element : rows.getRow()) {
                clonedRow.getRow().add(element);
            }
            clonedBoard.board.add(clonedRow);
        }
        return clonedBoard;
    }

    public boolean checkIfSudokuResolved() {
        return board.stream()
                .flatMap(n -> n.getRow().stream())
                .noneMatch(sudokuElement -> sudokuElement.getValue() == -1);
    }

    public void setElementValue(int row, int column, int value) {
        if (possibleValue(row, column, value))
            board.get(row).getRow().get(column).setValue(value);

    }

    public boolean possibleInAnotherElement(int row, int column, int value) {
        return possibleInAnotherElementRow(row, value) && possibleInAnotherElementColumn(column, value) && possibleInAnotherElementBox(row, column, value);
    }

    public boolean possibleInAnotherElementRow(int row, int value) {
        return board.get(row).getRow().stream()
                .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                .anyMatch(v -> v == value);
    }

    public boolean possibleInAnotherElementColumn(int column, int value) {
        return board.stream()
                .map(SudokuRow::getRow)
                .map(n -> n.get(column))
                .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                .anyMatch(v -> v == value);
    }

    private boolean possibleInAnotherElementBox(int row, int column, int value) {
        int r = row - row % 3;
        int c = column - column % 3;
        boolean possibleInBox = false;
        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board.get(i).getRow().get(j).getPossibleValues().contains(value)) possibleInBox = true;
        return possibleInBox;
    }

    public boolean possibleValue(int row, int column, int value) {
        return !existsInRow(row, value) && !existsInColumn(column, value) && !existsInBox(row, column, value);
    }

    private boolean existsInRow(int row, int value) {
        return board.get(row).getRow().stream()
                .anyMatch(element -> element.getValue() == value);
    }

    private boolean existsInColumn(int column, int value) {
        return board.stream()
                .map(SudokuRow::getRow)
                .anyMatch(element -> element.get(column).getValue() == value);
    }

    private boolean existsInBox(int row, int column, int value) {
        int r = row - row % 3;
        int c = column - column % 3;
        boolean existsInBox = false;
        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (board.get(i).getRow().get(j).getValue() == value) existsInBox = true;
        return existsInBox;
    }

    @Override
    public String toString() {
        String s = "----------------------------\n";
        for (int row = 0; row < SIZE; row++) {
            s += "|";
            for (int col = 0; col < SIZE; col++) {
                s += board.get(row).getRow().get(col).getValue() + "|";
            }
            s += "\n";
        }
        s += "----------------------------\n";
        return s;
    }
}
