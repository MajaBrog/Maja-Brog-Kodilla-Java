package com.kodilla.testing.shape;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }
    @Override
    public void getShapeName() {
        System.out.println("square") ;
    }

    @Override
    public void getField() {
        System.out.println("Field of Square equals" + side*side) ;
    }
}
