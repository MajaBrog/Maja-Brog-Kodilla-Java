package com.kodilla.rps;

import java.util.Random;

public class RPSgame {

    private PointsTo result;

    public void game() {

        while (result != PointsTo.EXIT) {
            String name=UserDialogs.getName();
            int max = UserDialogs.getNumberOfRounds();
            int winsOfUser = 0;
            int winsOfComputer = 0;
            RPSlogic round = new RPSlogic();
            UserSelection userMove;
            Random random = new Random();
            UserSelection computerMove;
            while (!(winsOfUser >= max || winsOfComputer >= max)) {
                userMove =UserDialogs.getUserMove();
                computerMove = UserSelection.values()[random.nextInt(UserSelection.values().length - 3)];
                result = round.getResult(userMove, computerMove);
                if (result != null) {
                    if (result == PointsTo.EXIT || result == PointsTo.RESTART)
                        break;
                    if (result == PointsTo.USER) {
                        winsOfUser += 1;
                    } else if (result == PointsTo.COMPUTER) {
                        winsOfComputer += 1;
                    }
                    UserDialogs.displayWinnerOfRound(name,userMove, computerMove, result, winsOfUser, winsOfComputer);
                }
            }
            if (result != PointsTo.EXIT&&result != PointsTo.RESTART)
                UserDialogs.displayWinner(name,max, winsOfUser, winsOfComputer);
            break;
        }
    }
}