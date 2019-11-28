package com.kodilla.sudoku;

public class UserInput {
    private Command command;
    private int col;
    private int row;
    private int value;

    public UserInput(Command command, int col, int row, int value) {
        this.command = command;
        this.col = col;
        this.row = row;
        this.value = value;
    }

    public UserInput(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getValue() {
        return value;
    }
}
