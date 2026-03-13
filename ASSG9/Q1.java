import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1. Write a Java Program to build a ticket reservation system for different types of
// events. The system should support various event types and allow users to book and
// cancel tickets. Base class should be designed in such a way that it should impose
// implementation of certain functions in the specific event class.
// Do the following:
    // 1. All events should have the functions: getEventName() returns the name of the
    // event, getAvailableTickets() returns the number of available tickets,
    // bookTickets(int numberOfTickets) books a specified number of tickets if
    // available and returns whether the booking was successful, cancelTickets(int
    // numberOfTickets) cancels a specified number of tickets.

    // 2. Specific events: Concert - represents a concert with properties such as
    // eventName, totalTickets, and performer. TheaterPlay - represents a theater
    // play with properties such as eventName, totalTickets, and director.
    // SportsGame - represents a sports game with properties such as eventName,
    // totalTickets, and teamNames. Each class should provide its own
    // implementation of the methods defined in the Event interface. For example:
    // Concert might display the performer in its details. TheaterPlay might display
    // the director in its details. SportsGame might display the team names in its
    // details.

    // 3. Create a class EventManager with the following methods: 
    //   - addEvent(Event event) adds an event to the manager's list, 
    //   - bookEventTickets(String eventName, int numberOfTickets) attempts to book 
    //      tickets for an event by its name, 
    //   - cancelEventTickets(String eventName, int numberOfTickets) cancels tickets 
    //      for an event by its name and 
    //   - displayAllEvents() displays details of all events.

    // 4. In the main method, create instances of Concert, TheaterPlay, and
    // SportsGame. Add these events to an EventManager instance. Demonstrate
    // booking and canceling tickets, and display event details as shown below.


class Event {
    public String eventName;
    private int availableTickets;

    public Event(String eventName, int availableTickets) {
        this.eventName = eventName;
        this.availableTickets = availableTickets;
    }

    public String getEventName() {
        return eventName;
    }

    public int getAvailableTickets() {
        return availableTickets;
    }

    public boolean bookTickets(int numberOfTickets) {
        if (numberOfTickets <= availableTickets) {
            availableTickets -= numberOfTickets;
            return true;
        }
        return false;
    }

    public void cancelTickets(int numberOfTickets) {
        if (numberOfTickets > 0) {
            availableTickets += numberOfTickets;
        }
    }

}

class Concert extends Event {
    private String performer;

    public Concert(String eventName, int totalTickets, String performer) {
        super(eventName, totalTickets);
        this.performer = performer;
    }

    @Override
    public String toString() {
        return "Concert: " + eventName + ", Performer: " + performer + ", Available Tickets: " + getAvailableTickets();
    }
}

class TheaterPlay extends Event {
    private String director;

    public TheaterPlay(String eventName, int totalTickets, String director) {
        super(eventName, totalTickets);
        this.director = director;
    }


    @Override
    public String toString() {
        return "Theater Play: " + eventName + ", Director: " + director + ", Available Tickets: " + getAvailableTickets();
    }
}

class SportsGame extends Event {
    private String[] teamNames;

    public SportsGame(String eventName, int totalTickets, String[] teamNames) {
        super(eventName, totalTickets);
        this.teamNames = teamNames;
    }

    @Override
    public String toString() {
        return "Sports Game: " + this.eventName + ", Teams: " + Arrays.toString(teamNames) + ", Available Tickets: " + getAvailableTickets();
    }
}

class EventManager {
    private Map<String, Event> events;

    public EventManager() {
        events = new HashMap<>();
    }

    public void addEvent(Event event) {
        events.put(event.getEventName(), event);
        System.out.println("Added event: " + event.getEventName());
    }

    public boolean bookEventTickets(String eventName, int numberOfTickets) {
        Event event = events.get(eventName);
        if (event != null) {
            return event.bookTickets(numberOfTickets);
        }
        return false;
    }

    public void cancelEventTickets(String eventName, int numberOfTickets) {
        Event event = events.get(eventName);
        if (event != null) {
            event.cancelTickets(numberOfTickets);
        }
    }

    public void displayAllEvents() {
        for (Event event : events.values()) {
            System.out.println(event.toString());
        }
    }
}

public class Q1 {
    public static void main(String[] args) {
        EventManager manager = new EventManager();
        Event concert = new Concert("Summer Music Festival", 100, "The Jazz Band");
        Event play = new TheaterPlay("Shakespeare's Hamlet", 50, "John Doe");
        Event sports = new SportsGame("City Derby", 200, new String[]{"Team A", "Team B"});
        manager.addEvent(concert); manager.addEvent(play);
        manager.addEvent(sports); // Demonstrate booking and canceling tickets
        manager.addEvent(sports);
        manager.displayAllEvents();

        
        manager.bookEventTickets("Summer Music Festival", 10);
        manager.cancelEventTickets("Shakespeare's Hamlet", 5); 
        
        // Display all events
        manager.displayAllEvents();
    }
}
