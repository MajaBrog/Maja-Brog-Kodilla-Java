package com.kodilla.testing;
import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args){
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calc= new Calculator();

        Integer addTest=calc.add(2,3);

        if (addTest.equals(2+3)){
            System.out.println("Add method OK");
        } else {
            System.out.println("Add method not OK");
        }

        Integer subtractTest=calc.subtract(5,3);

        if (subtractTest.equals(5-3)){
            System.out.println("Subtract method OK");
        } else {
            System.out.println("Subtract method not OK");
        }
    }
}