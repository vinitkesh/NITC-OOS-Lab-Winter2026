

// Create an abstract class called Shape that serves as a blueprint for a drawing
// application, containing a String color attribute, a constructor to initialize it, and a concrete
// method showColor() that prints the shape's color. 
// You must define an abstract method
// calculateArea() within this class, as the mathematical formula for area depends entirely
// on the specific type of shape being drawn. Implement two subclasses, Circle (using a
// radius) and Rectangle (using length and width), which provide their own unique versions
// of the area calculation. Finally, in a Main class, demonstrate polymorphism by creating a
// Shape array containing both a circle and a rectangle, then use a loop to display the color
// and calculated area for each.

abstract class Shape {
    String color;

    public Shape(String color) {
        this.color = color;
    }

    // concrete method to show color
    public void showColor() {
        System.out.println("Shape color: " + color);
    }

    // abstract method to calculate area
    public abstract double calculateArea();
}

class Circle extends Shape {
    double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    // override calculateArea method for Circle
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    public Rectangle(String color, double length, double width) {
        super(color);
        this.length = length;
        this.width = width;
    }

    @Override
    // override calculateArea method for Rectangle
    public double calculateArea() {
        return length * width;
    }
}


public class Q1 {

    public static void main(String[] args) {
        // Create an array of Shape objects
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle("Red", 5); // Circle with radius 5
        shapes[1] = new Rectangle("Blue", 4, 6); // Rectangle with length 4 and width 6

        // Loop through the array and display color and area for each shape
        for (Shape shape : shapes) {
            shape.showColor();
            System.out.println("Area: " + shape.calculateArea());
            System.out.println();
        }
    }
    
}
