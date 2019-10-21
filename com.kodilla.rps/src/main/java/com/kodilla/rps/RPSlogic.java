package com.kodilla.rps;

public class RPSlogic {

    public PointsTo getResult(UserSelection userMove, UserSelection computerMove) {
        PointsTo result = null;
        if ((userMove == UserSelection.ROCK) && (computerMove == UserSelection.ROCK)) {
            result = PointsTo.NO_WIN;
        } else if ((userMove == UserSelection.ROCK) && (computerMove == UserSelection.PAPER)) {
            result = PointsTo.COMPUTER;
        } else if ((userMove == UserSelection.ROCK) && (computerMove == UserSelection.SCISSORS)) {
            result = PointsTo.USER;

        } else if ((userMove == UserSelection.PAPER) && (computerMove == UserSelection.PAPER)) {
            result = PointsTo.NO_WIN;
        } else if ((userMove == UserSelection.PAPER) && (computerMove == UserSelection.SCISSORS)) {
            result = PointsTo.COMPUTER;
        } else if ((userMove == UserSelection.PAPER) && (computerMove == UserSelection.ROCK)) {
            result = PointsTo.USER;

        } else if ((userMove == UserSelection.SCISSORS) && (computerMove == UserSelection.SCISSORS)) {
            result = PointsTo.NO_WIN;
        } else if ((userMove == UserSelection.SCISSORS) && (computerMove == UserSelection.ROCK)) {
            result = PointsTo.COMPUTER;
        } else if ((userMove == UserSelection.SCISSORS) && (computerMove == UserSelection.PAPER)) {
            result = PointsTo.USER;
        } else if (userMove == UserSelection.EXIT) {
            result=PointsTo.EXIT;
        } else if (userMove == UserSelection.RESTART) {
            result=PointsTo.RESTART;
        }
        return result;
    }
}
