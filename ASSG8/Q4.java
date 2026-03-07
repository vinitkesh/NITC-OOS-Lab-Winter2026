// Create an interface Shape with abstract methods computeArea(). Create two different
// classes Circle and Square which implements Shape. Add the specific computeArea()
// function to the implemented classes along with required attributes.
// Note: From this exercise understand the necessity of Java Interface. This will help to use
// interfaces in such scenarios

interface Shape {
    double computeArea();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double computeArea() {
        return Math.PI * radius * radius;
    }
}

class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double computeArea() {
        return side * side;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape square = new Square(10);

        System.out.println("Area of Circle: " + circle.computeArea());
        System.out.println("Area of Square: " + square.computeArea());
    }
}
