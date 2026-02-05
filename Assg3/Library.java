class LibraryBook {
    String title;
    String author;
    double price;
    int yearPublished;

    LibraryBook(String title, String author, double price, int yearPublished) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.yearPublished = yearPublished;
    }

    void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Year Published: " + yearPublished);
    }
}

public class Library {
    public static void main(String[] args) {
        LibraryBook b1 = new LibraryBook("The Great Gatsby", "F. Scott Fitzgerald", 10.99, 1925);
        LibraryBook b2 = new LibraryBook("To Kill a Mockingbird", "Harper Lee", 7.99, 1960);
        LibraryBook b3 = new LibraryBook("1984", "George Orwell", 8.99, 1949);

        b1.displayDetails();
        b2.displayDetails();
        b3.displayDetails();
    }
}
