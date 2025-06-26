import java.beans.beancontext.BeanContextServiceRevokedListener;
import java.util.ArrayList;
import java.util.List;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issue() {
        isIssued = true;
    }

    public void returnBook() {
        isIssued = false;
    }

    @Override
    public String toString() {
        return id + "-" + title + " by " + author + " ( " + (isIssued ? " Issued " : " Available ") + ")";
    }

}

class User {
    private int userId;
    private String userName;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public int getuserId() {
        return userId;
    }

    public String getuserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "User ID : " + userId + ", Name : " + userName;
    }
}

class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void registerUser(User user) {
        users.add(user);
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (book == null) {
            System.out.println("Book not found.");
        } else if (user == null) {
            System.out.println("User not found.");
        } else if (book.isIssued()) {
            System.out.println("Book already issued.");
        } else {
            book.issue();
            System.out.println("book issueed to : " + user.getuserName());
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isIssued()) {
            book.returnBook();
            System.out.println("Book returned successfully..");
        } else {
            System.out.println("Book deos not exist.");
        }
    }

    public void showBook() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showUser() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    public Book findBookById(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public User findUserById(int userId) {
        for (User user : users) {
            if (user.getuserId() == userId) {
                return user;
            }
        }
        return null;
    }
}

public class LibraryManagement {

    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book(1, " Harry Potter ", " J.K Roeling"));
        library.addBook(new Book(2, "The Lord Of the Rings ", " J.R.R Tolkien"));
        library.addBook(new Book(3, "A Thousand Splendid Sun ", " Khaled Hosseini"));
        library.addBook(new Book(4, "A Kite Runner", " Khaled Hosseini"));
        library.addBook(new Book(5, "And The Mountain Echoed ", " Khaled Hosseini"));
        library.addBook(new Book(6, "Thats Not My Name ", " Megan Lally"));
        library.addBook(new Book(7, "7 Rules OF Love ", " Jay Shetty"));
        library.addBook(new Book(8, "Give Me The Hills ", " Miriam Underhill"));
        library.addBook(new Book(9, "Call Me By Your Name ", " Andre` Aciman"));
        library.addBook(new Book(10, "The Hunter ", " Tana French"));

        library.registerUser(new User(1, "Hafsa Moin"));
        library.registerUser(new User(2, "Kumar Raj"));
        library.registerUser(new User(3, "Aditi Kumari"));
        library.registerUser(new User(4, "Debika Sahoo"));
        library.registerUser(new User(5, "Shaikh Juhi"));

        System.out.println("Available Books: ");
        library.showBook();
        System.out.println();

        library.issueBook(5, 1);
        System.out.println();

        System.out.println("Books after issuing: ");
        library.showBook();
        System.out.println();

        library.returnBook(5);
        System.out.println();

        System.out.println("Book after returning:");
        library.showBook();
        System.out.println();

    }

}
