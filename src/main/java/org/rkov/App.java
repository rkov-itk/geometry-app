package org.rkov;

import java.util.Map;

import org.rkov.geometry.Circle;
import org.rkov.geometry.Rectangle;
import org.rkov.geometry.Triangle;
import org.rkov.geometry.ports.AreaCalculator;
import org.rkov.geometry.ports.PerimeterCalculator;

public class App 
{
    public static void main( String[] args )
    {
        var rectangle = new Rectangle(10, 20);
        var triangle = new Triangle(5, 5, 6);
        var circle = new Circle(10);

        
        Map<String, AreaCalculator> figures = Map.of(
            "rectangle", rectangle, 
            "triangle", triangle,
            "circle", circle
        );

        figures.forEach((name, figure) -> {
            System.out.println("Area of " + name + " is: " + figure.getSquare());
        });

        Map<String, PerimeterCalculator> figuresPerimeter = Map.of(
            "rectangle", rectangle, 
            "triangle", triangle,
            "circle", circle
        );
        figuresPerimeter.forEach((name, figure) -> {
            System.out.println("Perimeter of " + name + " is: " + figure.getPerimeter());
        });
    }
}
