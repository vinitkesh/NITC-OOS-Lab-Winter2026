// There is a class Book, which has the attributes bookID, title and author. There are two
// categories of books, TextBooks and ReferenceBooks. The text books can be borrowed
// by a user while the reference books cannot be. There is an extra attribute status (default
// value is Available) and borrowedUser in the class TextBooks. There is an interface
// Borrowable which has methods checkIn and checkOut. 

// The class Book implements the
// Borrowable interface 

// (Think and decide whether class Book is an abstract class or not). -> Yes
// Yes, class Book should be an abstract class because it contains common attributes 
// and methods for both TextBooks and ReferenceBooks, but it does not provide a 
// complete implementation of the checkIn and checkOut methods. 
// The specific behavior // of these methods differs between TextBooks and ReferenceBooks, 
// so it makes sense to declare Book as an abstract class and let the subclasses provide their
// own implementations of the Borrowable interface methods.


// The functionality of the checkIn and checkOut methods in TextBooks class is as follows:
    // checkIn : should set status attribute as Borrowed and should set the value of borrowedUser.
    // checkOut : should set status attribute as Available
// The functionality of the checkIn and checkOut methods in ReferenceBooks class is as follows:
    // checkIn : display "Invalid"
    // checkOut : display "Cannot be borrowed"

interface Borrowable {
    void checkIn(String user);
    void checkOut();
}

abstract class Book implements Borrowable {
    protected String bookID;
    protected String title;
    protected String author;

    public Book(String bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }
}



class TextBook extends Book {
    private String status;
    private String borrowedUser;

    public TextBook(String bookID, String title, String author) {
        super(bookID, title, author);
        this.status = "Available";
        this.borrowedUser = null;
    }

    @Override
    public void checkIn(String user) {
        if (status.equals("Available")) {
            status = "Borrowed";
            borrowedUser = user;
            System.out.println("TextBook checked out to: " + borrowedUser);
        } else {
            System.out.println("TextBook is already borrowed by: " + borrowedUser);
        }
    }

    @Override
    public void checkOut() {
        if (status.equals("Borrowed")) {
            status = "Available";
            System.out.println("TextBook returned by: " + borrowedUser);
            borrowedUser = null;
        } else {
            System.out.println("TextBook is already available.");
        }
    }
}

class ReferenceBook extends Book {
    public ReferenceBook(String bookID, String title, String author) {
        super(bookID, title, author);
    }

    @Override
    public void checkIn(String user) {
        System.out.println("Invalid");
    }

    @Override
    public void checkOut() {
        System.out.println("Cannot be borrowed");
    }
}

public class Q6 {
    public static void main(String[] args) {

        TextBook textBook = new TextBook("TB001", "Introduction to Java", "John Doe");
        ReferenceBook referenceBook = new ReferenceBook("RB001", "Java Programming Reference", "Jane Smith");

        // Testing TextBook
        textBook.checkIn("Alice");
        textBook.checkIn("Bob"); // Should indicate already borrowed
        textBook.checkOut();
        textBook.checkOut(); // Should indicate already available

        // Testing ReferenceBook
        referenceBook.checkIn("Charlie"); // Should display "Invalid"
        referenceBook.checkOut(); // Should display "Cannot be borrowed"
        
    }
}
