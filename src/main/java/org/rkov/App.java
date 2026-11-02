package org.rkov;

import java.util.Map;

import org.rkov.geometry.Circle;
import org.rkov.geometry.Rectangle;
import org.rkov.geometry.Triangle;
import org.rkov.geometry.ports.AreaCalculator;
import org.rkov.geometry.ports.PerimeterCalculator;
import org.rkov.geometry.threedimensional.Cube;
import org.rkov.geometry.threedimensional.Cylinder;
import org.rkov.geometry.threedimensional.Sphere;
import org.rkov.geometry.utils.Unit;
import org.rkov.geometry.utils.UnitMeasurementValue;

public class App {
    public static void main(String[] args) {
        var rectangle = new Rectangle(10, 20);
        var triangle = new Triangle(5, 5, 6);
        var circle = new Circle(10);


        Map<String, AreaCalculator> figures = Map.of(
                "rectangle", rectangle,
                "triangle", triangle,
                "circle", circle
        );

        figures.forEach(App::printArea);

        Map<String, PerimeterCalculator> figuresPerimeter = Map.of(
                "rectangle", rectangle,
                "triangle", triangle,
                "circle", circle
        );

        figuresPerimeter.forEach(App::printPerimeter);

        Triangle triangle2 = new Triangle(10);

        printArea("triangle2", triangle2);

        printPerimeter("triangle2", triangle2);

        UnitMeasurementValue value = new UnitMeasurementValue(Unit.METER, Unit.MILLIMETER);

        figures.forEach((name, figure) -> {
            var square = figure.getSquare();

            var newValue = value.update(square);

            System.out.println("From meter " + square + " to millimeter is: " + newValue);
        });

        var figures3D = Map.of(
                "cube", new Cube(10),
                "sphere", new Sphere(10),
                "cylinder", new Cylinder(10, 20)
        );

        figures3D.forEach(App::printArea);
    }

    private static void printArea(String name, AreaCalculator figure) {
        System.out.println("Area of " + name + " is: " + figure.getSquare());
    }

    private static void printPerimeter(String name, PerimeterCalculator figure) {
        System.out.println("Perimeter of " + name + " is: " + figure.getPerimeter());
    }

    private static void printArea(String name, org.rkov.geometry.threedimensional.ports.AreaCalculator figure) {
        System.out.println("Area of 3D " + name + " is: " + figure.getSquare());
    }
}
