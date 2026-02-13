
import java.util.ArrayList;
import java.util.List;

class HierarchicalManager<T extends Entity> {

    private List<T> entities = new ArrayList<>();

    public void addEntity(T entity) {
        entities.add(entity);
    }

    public void removeEntity(T entity) {
        entities.remove(entity);
    }

    public List<T> getAllEntities() {
        return new ArrayList<>(entities);
    }

    // passing classes in java


    public List<T> getEntitiesByType(Class<? extends T> type) {
        List<T> result = new ArrayList<>();
        for (T entity : this.entities) {
            if (type.isInstance(entity)) {
                result.add(entity);
            }
        }
        return result;
    }

    public void printHierarchy() {
        for (T entity : entities) {
            System.out.println(entity + " - Type: " + entity.getClass().getSimpleName());
        }
    }
}

class Entity {

    String name;

    public Entity(String name) {
        this.name = name;
    }

    public String toString() {
        return "Entity{name='" + name + "'}";
    }
}

class Employee extends Entity {

    String employeeId;

    public Employee(String name, String employeeId) {
        super(name);
        this.employeeId = employeeId;
    }

    public String toString() {
        return "Employee details \n  {name='" + name + "', employeeId='" + employeeId + "'}";
    }
}

class Manager extends Employee {

    String team;

    public Manager(String name, String employeeId, String team) {
        super(name, employeeId);
        this.team = team;
    }

    public String toString() {
        return "Manager{name='" + name + "', employeeId='" + employeeId + "', team='" + team + "'}";
    }
}

public class Q3 {
    public static void main(String[] args) {

        HierarchicalManager<Entity> manager = new HierarchicalManager<>();

        Employee e1 = new Employee("Alice", "E101");
        Employee e2 = new Employee("Bob", "E102");
        Manager m1 = new Manager("Charlie", "M201", "Engineering");

        manager.addEntity(e1);
        manager.addEntity(e2);
        manager.addEntity(m1);

        manager.printHierarchy();
    }
}
