// Write a java program to iterate through a list of Flowers
class Flower {
    private String name;
    private String color;

    Flower (String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
}
// Use Iterator to iterate through the instances.

public class Q5 {
    public static void main(String[] args) {
        java.util.List<Flower> flowers = new java.util.ArrayList<>();
        flowers.add(new Flower("Rose", "Red"));
        flowers.add(new Flower("Lily", "White"));
        flowers.add(new Flower("Tulip", "Yellow"));

        java.util.Iterator<Flower> iterator = flowers.iterator();
        while (iterator.hasNext()) {
            Flower flower = iterator.next();
            System.out.println("Flower Name: " + flower.getName() + ", Color: " + flower.getColor());
        }
    }
}