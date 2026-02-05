import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author);
    }
}

public class LibraryManagement {
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Title: ");
        String title = sc.nextLine();
        System.out.print("Enter Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully");
    }

    public static void removeBook() {
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();

        books.removeIf(book -> book.id == id);
        System.out.println("Book removed if it existed");
    }

    public static void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available");
        } else {
            for (Book b : books) {
                b.display();
            }
        }
    }

    public static void findBook() {
        sc.nextLine();
        System.out.print("Enter title to search: ");
        String title = sc.nextLine();

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                b.display();
                return;
            }
        }
        System.out.println("Book not found");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1.Add 2.Remove 3.List 4.Find 5.Exit");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    listAllBooks();
                    break;
                case 4:
                    findBook();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
