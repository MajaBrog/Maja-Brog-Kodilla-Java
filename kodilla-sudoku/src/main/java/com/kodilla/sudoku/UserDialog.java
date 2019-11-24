package com.kodilla.sudoku;
import java.util.Scanner;

public class UserDialog {
    public static String getInput() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter the row, column and number separated by comma or type SUDOKU to resolve");
        return scan.nextLine();
    }
    public static boolean newGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Do you want to resolve another Sudoku (Y/N)?");
            char move = scanner.next().charAt(0);
            if(move=='Y'){
                return true;
            }else if(move=='N'){
                return false;
            }else{
                System.out.println("Wrong, try again");
            }
        }
    }
}
