package com.kodilla.exception.test;

public class ExceptionHandling {
    public static void main(String[] args) {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            System.out.println(secondChallenge.probablyIWillThrowException(2.0, 5.0));
        } catch (Exception e) {
            System.out.println("Wrong arguments : x >= 2 or x < 1 or y == 1.5");
        } finally {
            System.out.println("the end");
        }
    }
}
