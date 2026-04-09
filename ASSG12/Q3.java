// You are implementing drawing application that supports various shapes, including
// circles, rectangles, and triangles. Implement a Factory Method design pattern to create
// instances of these shapes. Define an interface Shape with a method draw that outputs
// the name of the shape. Create concrete classes for Circle, Rectangle, and Triangle,
// each implementing the Shape interface with their unique draw methods. Finally, create a
// ShapeFactory class with factory methods to create each type of shape. In the main
// function, accept user input for the shape name and instantiate based on user input.

class ShapeFactory {
    public static Shape createShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.toUpperCase().equals("CIRCLE")) {
            return new Circle();
        } else if (shapeType.toUpperCase().equals("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.toUpperCase().equals("TRIANGLE")) {
            return new Triangle();
        }
        return null;
    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}

public class Q3 {
    public static void main(String[] args) {
        String shapeName = "Circle"; // You can change this to "Rectangle" or "Triangle" for testing
        Shape shape = ShapeFactory.createShape(shapeName);
        if (shape != null) {
            shape.draw();
        } else {
            System.out.println("Invalid shape type: " + shapeName);
        }

        Shape shape2 = ShapeFactory.createShape("Rectangle");
        if (shape2 != null) {
            shape2.draw();
        } else {
            System.out.println("Invalid shape type: Rectangle");
        }
    }
}



