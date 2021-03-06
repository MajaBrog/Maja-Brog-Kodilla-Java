package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private double height;
    private double base;

    public Triangle(double height, double base) {
        this.height = height;
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }

    @Override
    public void getShapeName() {
        System.out.println("Triangle") ;
    }

    @Override
    public void getField() {
        System.out.println("Field of Triangle equals" + base*height) ;
    }
}
