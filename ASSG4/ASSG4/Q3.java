
    // There can be multiple copies of a book. The software should have a datastructure to manage
    // the count of each book when added. addCopy(String isbn) function should help to add a copy of
    // a book.
    // Hint: use HashMap

class Book {
    private final String isbn;
    private final String title;
    private final String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class LibraryManager { 
    // Using Hashmap as the datastructure
    // key : ISBN of the book
    // value : number of copies

    private final java.util.HashMap<String, Integer> bookCopyCount;

    // To store book details
    // key : ISBN of the book
    // value : Book object
    private final java.util.HashMap<String, Book> books;

    public LibraryManager() {
        bookCopyCount = new java.util.HashMap<>();
        books = new java.util.HashMap<>();
    }

    public void addNewBook(Book book) {
        bookCopyCount.putIfAbsent(book.getIsbn(), 0);
        books.put(book.getIsbn(), book);
    }

    public void addCopy(String isbn) {
        if(bookCopyCount.containsKey(isbn)){
            int currentCount = bookCopyCount.get(isbn);
            bookCopyCount.put(isbn, currentCount + 1);
        } 
        else{
            // No copies exist
            System.out.println("No copies exist. Add the book to system.");
            return;
        }
    }

    public int getCopyCount(String isbn) {
        return bookCopyCount.getOrDefault(isbn, 0);
    }
}

public class Q3 {
    public static void main(String[] args) {

        Book b1 = new Book("ISBN001", "The Great Gatsby", "F. Scott Fitzgerald");
        Book b2 = new Book("ISBN002", "1984", "George Orwell");
        Book b3 = new Book("ISBN003", "To Kill a Mockingbird", "Harper Lee");
        Book b4 = new Book("ISBN004", "Pride and Prejudice", "Jane Austen");

        LibraryManager library = new LibraryManager();

        //add books
        library.addNewBook(b1);
        library.addNewBook(b2);
        library.addNewBook(b3);

        //add copies of books
        library.addCopy("ISBN001");
        library.addCopy("ISBN001");
        library.addCopy("ISBN001");
        library.addCopy("ISBN002");

        System.out.println("Copies of ISBN001: " + library.getCopyCount("ISBN001")); // Output: 3
        System.out.println("Copies of ISBN002: " + library.getCopyCount("ISBN002")); // Output: 1
        System.out.println("Copies of ISBN004: " + library.getCopyCount("ISBN004")); // Output: error

        library.addNewBook(b4);
        library.addCopy("ISBN004");

        System.out.println("Copies of ISBN004: " + library.getCopyCount("ISBN004")); // Output: 0
    }
}