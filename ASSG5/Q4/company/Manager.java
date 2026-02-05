package company;

public class Manager extends Employee {

    public Manager(String name) {
        super(name);
    }

    // Accessing protected field from subclass (allowed)
    public void printName() {
        System.out.println("Manager name: " + name);
    }

    // Modifying protected field from subclass
    public void changeName(String newName) {
        name = newName;
    }
}
