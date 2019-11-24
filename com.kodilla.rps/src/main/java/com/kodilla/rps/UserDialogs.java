package com.kodilla.rps;

import java.util.Scanner;


public class UserDialogs {

        public static String getName() {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please, enter your name:");
            return scan.nextLine();
        }

    public static int getNumberOfRounds() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please, enter number of rounds:");
        int numberOfRounds= scan.nextInt();
        System.out.println("Game instruction:\n" +
                "[1] - rock, [2] - paper, [3] - scissors, [x] - exit, [n] - new game");
        return numberOfRounds;
    }

    public static UserSelection getUserMove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please enter your move:");
            char move = scanner.next().charAt(0);
            if (move == '1') {
                return UserSelection.ROCK;
            } else if (move == '2') {
                return UserSelection.PAPER;
            } else if (move == '3') {
                return UserSelection.SCISSORS;
            } else if (move == 'x') {
                if (userWantsToExit())
                    return UserSelection.EXIT;
            } else if (move == 'n') {
                if (userWantsToRestart())
                    return UserSelection.RESTART;
            } else {
                System.out.println("Wrong, try again!");
            }
        }
    }

    private static boolean userWantsToRestart() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Do you really want to restart (Y/N)?");
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

    private static boolean userWantsToExit() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Do you really want to exit (Y/N)?");
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
    public static void displayWinnerOfRound(String name, UserSelection userMove, UserSelection computerMove, PointsTo result, int winsOfUser, int winsOfComputer) {
        if(result==PointsTo.USER){
            System.out.println("Great, You've won this round cause " + userMove + " wins with " + computerMove);
        }else if(result==PointsTo.COMPUTER){
            System.out.println("Oh, You've lost this round cause " + userMove + " loses with " + computerMove);
        }else if(result==PointsTo.NO_WIN){
            System.out.println("No one wins in this round, you both choose " + userMove);
        }
        System.out.println("Current score: " + "\n" + name + " won : " + winsOfUser + " times"
                + "\n" + name + " lost : " + winsOfComputer + " times");
    }
    public static void displayWinner(String name, int numberOfRounds,int winsOfUser,int winsOfComputer){
        if (winsOfUser == numberOfRounds) {
            System.out.println("Congrats " + name + ", you are the winner!");
        } else {
            System.out.println("Sorry " + name + ", you are the looser!");
        }
    }

}
