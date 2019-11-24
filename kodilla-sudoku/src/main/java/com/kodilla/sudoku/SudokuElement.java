package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SudokuElement {

    private int value;
    private final int EMPTY = -1;
    List<Integer> possibleValues;

    SudokuElement() {
        this.value = EMPTY;
        this.possibleValues = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
    }

    List<Integer> getPossibleValues() {
        return possibleValues;
    }

    int getValue() {
        return value;
    }

    void setValue(int value) {
        this.value = value;
    }

     void removeValue(int value){
        possibleValues.remove(value);

     }
}
