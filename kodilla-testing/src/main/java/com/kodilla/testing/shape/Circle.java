package com.kodilla.testing.shape;

import java.lang.Math;
public class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }
    @Override
    public void getShapeName() {
        System.out.println("Circle") ;
    }

    @Override
    public void getField() {
        double field=Math.PI*radius*radius;
        System.out.println("Field of Circle equals" + field) ;
    }
}
