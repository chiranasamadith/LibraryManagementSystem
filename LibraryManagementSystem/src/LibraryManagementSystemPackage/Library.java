package LibraryManagementSystemPackage;

import java.util.ArrayList;
import java.util.List;

public class Library {
    public List<Book> books;
    public List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(String title, String author) {
        Book book = new Book(title,author);
        books.add(book);
    }

    public void addUser(String name) {
        users.add(new User(name));
    }

    public void issueBook(User user, Book book) {
        if (book.isAvailable()) {
            user.addIssuedBook(book);
            book.setAvailable(false);
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook(User user, Book book) {
        if (user.getIssuedBooks().contains(book)) {
            user.getIssuedBooks().remove(book);
            user.addReturnedBook(book);
            book.setAvailable(true);
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not issued by this user.");
        }
    }

    public void viewAvailableBooks() {
        System.out.println("Available books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public void viewIssuedBooks(User user) {
        System.out.println(user.getName() + "'s issued books:");
        for (Book book : user.getIssuedBooks()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public void viewReturnedBooks(User user) {
        System.out.println(user.getName() + "'s returned books:");
        for (Book book : user.getReturnedBooks()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public void viewUsers() {
        System.out.println("Library users:");
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    public void viewAllBooks() {
        System.out.println("All books:");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Available: " + book.isAvailable());
        }
    }
}
