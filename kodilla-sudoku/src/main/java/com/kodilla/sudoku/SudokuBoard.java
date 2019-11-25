package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SudokuBoard extends Prototype {
    private List<SudokuRow> rows;
    private static final int SIZE = 9;
    private final int EMPTY = -1;
    private List<Guess> backtrack = new ArrayList<>();

    public SudokuBoard() {
        rows = new ArrayList<SudokuRow>();
        for (int i = 0; i < SIZE; i++) {
            rows.add(i, new SudokuRow());
        }
    }

    public void setRows(List<SudokuRow> rows) {
        this.rows = rows;
    }

    public List<SudokuRow> getRows() {
        return rows;
    }

    public void resolve() {
        while (!checkIfSudokuResolved()) {
            //usuwamy z possibleValues rzeczy niemożliwe
            for (int row = 0; row < SIZE; row++) {
                for (int column = 0; column < SIZE; column++) {
                    //usuwamy wszystko co w wierszu
                    removePossiblesFromRow(row, column);
                    //wszystkow co w kolumnie
                    removePossiblesFromCol(row, column);
                    //wszystko co w 3x3
                    removePossiblesBox(row, column);
                }
            }

            //sprawdzamy czy została jedna jak tak to wpisujemy
            for (int row = 0; row < SIZE; row++) {
                for (int column = 0; column < SIZE; column++) {
                    if(getElement(row,column).getValue()==EMPTY)
                        setValueIfOnlyOne(row,column);
                }
            }

            //

        }


//        while (!
//
//                checkIfSudokuResolved()) {
//            boolean valueAdded = false;
//            for (int row = 0; row < SIZE; row++)
//                for (int column = 0; column < SIZE; column++) {
//                    SudokuElement element = rows.get(row).getCols().get(column);
//                    if (element.getValue() == EMPTY) {
//                        if (element.getPossibleValues().size() != 1) {
//                            for (int value : element.getPossibleValues()) {
//                                if (!possibleValue(row, column, value)) element.removePossibleValue(value);
//                                else if (!possibleInAnotherElement(row, column, value)) {
//                                    setElementValue(row, column, value);
//                                    valueAdded = true;
//                                }
//                            }
//                        } else {
//                            if (possibleValue(row, column, element.getPossibleValues().get(0))) {
//                                setElementValue(row, column, element.getPossibleValues().get(0));
//                                valueAdded = true;
//                            } else {
//                                //błąd
//                                if (backtrack.size() > 0) {
//                                    Guess lastBacktrack = backtrack.get(backtrack.size() - 1);
//                                    int guessedRow = lastBacktrack.getRow();
//                                    int guessedColumn = lastBacktrack.getColumn();
//                                    int guessedValue = lastBacktrack.getValue();
//                                    setRows(lastBacktrack.getSudokuBoard().getRows());
//                                    rows.get(guessedRow).getCols().get(guessedColumn).getPossibleValues().remove(guessedValue);
//                                } else System.out.println("Sudoku cannot be resolved!");
//
//                            }
//                        }
//                    }
//                }
//            if (!valueAdded) {
//                guessValue();
//            }
//            if (!checkIfResolvable()) {
//                if (backtrack.size() > 0) {
//                    setRows(backtrack.get(backtrack.size() - 1).getSudokuBoard().getRows());
//
//                }
//            }
//        }

    }

    private void setValueIfOnlyOne(int row, int column) {
        if(getPossibles(row,column).size()==1){
            Integer value=getPossibles(row,column).get(0);
            setValue(row,column,value);
        }
    }

    private void setValue(int row, int column, Integer value) {
        getElement(row,column).setValue(value);
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

    public boolean checkIfResolvable() {
        boolean resolvableSudoku = true;
        List<SudokuElement> elementWithoutSolution = rows.stream()
                .flatMap(n -> n.getCols().stream())
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
            randomElement = rows.get(randomRow).getCols().get(randomColumn);
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
        clonedBoard.rows = new ArrayList<>();
        for (SudokuRow rows : rows) {
            SudokuRow clonedRow = new SudokuRow();
            for (SudokuElement element : rows.getCols()) {
                clonedRow.getCols().add(element);
            }
            clonedBoard.rows.add(clonedRow);
        }
        return clonedBoard;
    }

    public boolean checkIfSudokuResolved() {
        return rows.stream()
                .flatMap(n -> n.getCols().stream())
                .noneMatch(sudokuElement -> sudokuElement.getValue() == -1);
    }

    public void setElementValue(int row, int column, int value) {
        if (possibleValue(row, column, value))
            rows.get(row).getCols().get(column).setValue(value);

    }

    public boolean possibleInAnotherElement(int row, int column, int value) {
        return possibleInAnotherElementRow(row, value) && possibleInAnotherElementColumn(column, value) && possibleInAnotherElementBox(row, column, value);
    }

    public boolean possibleInAnotherElementRow(int row, int value) {
        return rows.get(row).getCols().stream()
                .flatMap(sudokuElement -> sudokuElement.getPossibleValues().stream())
                .anyMatch(v -> v == value);
    }

    public boolean possibleInAnotherElementColumn(int column, int value) {
        return rows.stream()
                .map(SudokuRow::getCols)
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
                if (rows.get(i).getCols().get(j).getPossibleValues().contains(value)) possibleInBox = true;
        return possibleInBox;
    }

    public boolean possibleValue(int row, int column, int value) {
        return !existsInRow(row, value) && !existsInColumn(column, value) && !existsInBox(row, column, value);
    }

    private boolean existsInRow(int row, int value) {
        return rows.get(row).getCols().stream()
                .anyMatch(element -> element.getValue() == value);
    }

    private boolean existsInColumn(int column, int value) {
        return rows.stream()
                .map(SudokuRow::getCols)
                .anyMatch(element -> element.get(column).getValue() == value);
    }

    private boolean existsInBox(int row, int column, int value) {
        int r = row - row % 3;
        int c = column - column % 3;
        boolean existsInBox = false;
        for (int i = r; i < r + 3; i++)
            for (int j = c; j < c + 3; j++)
                if (rows.get(i).getCols().get(j).getValue() == value) existsInBox = true;
        return existsInBox;
    }

    @Override
    public String toString() {
        String s = "----------------------------\n";
        for (int row = 0; row < SIZE; row++) {
            s += "|";
            for (int col = 0; col < SIZE; col++) {
                s += rows.get(row).getCols().get(col).getValue() + "|";
            }
            s += "\n";
        }
        s += "----------------------------\n";
        return s;
    }
}
