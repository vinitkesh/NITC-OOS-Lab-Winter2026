
import java.util.ArrayList;
import java.util.List;

// Design a library management system that models the relationship between Library, Book, and
// Author.The system should demonstrate the following relationships:
// An aggregation (has-a) relationship between the Library and Book classes, where the library
// contains a collection of books, but the books can exist independently of the library.
// A composition (has-a) relationship between the Book and Author classes, where each book is
// associated with a specific author, and if the book is deleted, the associated author should also
// be deleted.

class Author{
    private String name;
    private String nationality;

    Author(String name, String nationality){
        this.name = name;
        this.nationality = nationality;
    }

    public String getName(){
        return this.name;
    }
    public String getNationality(){
        return this.nationality;
    }
    public void displayAuthorInfo(){
        System.out.println("The author " + this.name + " is from " + this.nationality);
    }
}

class Book {
    private String title;
    private String isbn;
    private Author author;

    public Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        // making sure composition is applied
        this.author = new Author(author.getName(), author.getNationality());
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() { 
        return isbn;
    }

    public void displayBookInfo(){
        System.out.println("Book details : \n  Title: " + this.title + ", ISBN: " + this.isbn + "\n  Author: " + this.author.getName());
    }
}

class Library {
    List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }

    public void displayBooks(){
        System.out.println("Books :\n");
        for (Book b : books){
            b.displayBookInfo();
        }
    }
    

}

public class Q4 {

    public static void main(String[] args) {

        // Creating books with authors (Composition: Book owns Author)
        Book b1 = new Book("The Alchemist", "1111", 
                           new Author("Paulo Coelho", "Brazilian"));

        Book b2 = new Book("1984", "2222", 
                           new Author("George Orwell", "British"));

        // Creating library (Aggregation: Library has Books)
        Library library = new Library();

        library.addBook(b1);
        library.addBook(b2);

        library.displayBooks();
    }
}


