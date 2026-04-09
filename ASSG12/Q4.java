// You are developing a game that features various characters, including warriors and
// mages. Each character type has unique abilities and characteristics. Implement the
// Factory Method design pattern to create instances of these characters. Define an
// interface Character with methods for getting the character's name and abilities. Create
// concrete classes for Warrior and Mage, both implementing the Character interface with
// their own unique abilities and names. Then, create a CharacterFactory class with factory
// methods to create characters of each type. Write a Java program to demonstrate the use
// of the Factory Method pattern by creating instances of warriors and mages and
// displaying their names and abilities. Character should have methods getName() and
// getAbilities()

class CharacterFactory {
    public static Character createCharacter(String characterType) {
        if (characterType == null) {
            return null;
        }
        if (characterType.toUpperCase().equals("WARRIOR")) {
            return new Warrior();
        } else if (characterType.toUpperCase().equals("MAGE")) {
            return new Mage();
        }
        return null;
    }
}

interface Character {
    String getName();
    String getAbilities();
}

class Warrior implements Character {
    @Override
    public String getName() {
        return "Warrior";
    }

    @Override
    public String getAbilities() {
        return "Sword Mastery, Shield Block, Battle Cry";
    }
}

class Mage implements Character {
    @Override
    public String getName() {
        return "Mage";
    }

    @Override
    public String getAbilities() {
        return "Fireball, Teleportation, Arcane Shield";
    }
}

public class Q4 {
    public static void main(String[] args) {
        String characterType1 = "Warrior";
        Character character1 = CharacterFactory.createCharacter(characterType1);
        if (character1 != null) {
            System.out.println("Character: " + character1.getName());
            System.out.println("Abilities: " + character1.getAbilities());
        } else {
            System.out.println("Invalid character type: " + characterType1);
        }

        String characterType2 = "Mage";
        Character character2 = CharacterFactory.createCharacter(characterType2);
        if (character2 != null) {
            System.out.println("Character: " + character2.getName());
            System.out.println("Abilities: " + character2.getAbilities());
        } else {
            System.out.println("Invalid character type: " + characterType2);
        }
    }
} 