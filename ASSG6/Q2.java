// A farm simulator has an Animal class and classes specific to each animal; cow, goat, hen,
// turkey. Animal class should have functions to eat, makeSound. There is a Shelter class which
// supports the admission and release of specific animal instances. It should not support any other
// class other than the ones inherited from Animal. Making use of Generics write a Java program
// which can make the following main function work.

class Shelter<T extends Animal> {
    private T animal;

    public void admit(T animal) {
        this.animal = animal;
        System.out.println("Admitted: " + animal.getClass().getSimpleName());
    }

    public void release() {
        System.out.println("Released: " + animal.getClass().getSimpleName());
        this.animal = null;
    }

    public void listAnimal() {
        if (animal != null) {
            animal.eat();
            animal.makeSound();
        } else {
            System.out.println("No animals in the shelter.");
        }
    }
}

class Animal {
    public void eat() {
        System.out.println("Animal is eating");
    }

    public void makeSound() {
        System.out.println("Animal sound");
    }
}

class Cow extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Moo");
    }

    @Override
    public void eat() {
        System.out.println("Cow is eating grass");
    }
}

class Turkey extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Quack");
    }

    @Override
    public void eat() {
        System.out.println("Turkey is eating grains");
    }
}

class Hen extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cluck");
    }

    @Override
    public void eat() {
        System.out.println("Hen is eating seeds");
    }
}

public class Q2 {
    public static void main(String[] args) {
        // This works because Cow extends Animal
        Shelter<Cow> cowShelter = new Shelter<>();
        cowShelter.admit(new Cow());
        // This works because Turkey extends Animal
        Shelter<Turkey> turkeyShelter = new Shelter<>();
        turkeyShelter.admit(new Turkey());
        // Following code should fail
        // Shelter<String> stringShelter = new Shelter<>();

        turkeyShelter.listAnimal();
        cowShelter.listAnimal();
    }
}