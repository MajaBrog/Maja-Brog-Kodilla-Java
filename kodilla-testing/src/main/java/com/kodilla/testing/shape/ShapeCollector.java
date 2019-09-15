package com.kodilla.testing.shape;

import java.util.*;

public class ShapeCollector {

    private List<Shape> shapes= new ArrayList<>();


    public void addFigure(Shape shape){
        shapes.add(shape);
    }

    public boolean removeFigure(Shape shape){
        return shapes.remove(shape);
    }

    public Shape getFigure(int n){
        if(n <shapes.size() && n>=0){
            return shapes.get(n);
        } else {
            return null;
        }
    }

    public void showFigures(){
        System.out.println(shapes.toString());
    }

    public  List<Shape> getShapes() {
        return shapes;
    }
}
