package com.kodilla.sudoku;

import java.util.Scanner;

public class UserDialog {

    public static boolean newGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to resolve another Sudoku (Y/N)?");
            char move = scanner.next().charAt(0);
            if (move == 'Y') {
                return false;
            } else if (move == 'N') {
                return true;
            } else {
                System.out.println("Wrong, try again");
            }
        }
    }

    public static UserInput getUserInput() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("Enter move: XYV (column, row, value), RESOLVE, DEMO, EXIT");
            String s = scan.nextLine().toUpperCase();
            switch (s) {
                case "RESOLVE":
                    return new UserInput(Command.RESOLVE);
                case "EXIT":
                    return new UserInput(Command.EXIT);
                case "DEMO":
                    return new UserInput(Command.DEMO);
                default:
                    try {
                        int col = Integer.parseInt(s.substring(0, 1));
                        int row = Integer.parseInt(s.substring(1, 2));
                        int val = Integer.parseInt(s.substring(2, 3));
                        if (col < 1 || row < 1 || val < 1)
                            throw new RuntimeException();
                        return new UserInput(Command.VALUE, col - 1, row - 1, val);
                    } catch (Exception e) {
                        System.out.println("Wrong data, try again");
                    }
            }
        }
    }
}
