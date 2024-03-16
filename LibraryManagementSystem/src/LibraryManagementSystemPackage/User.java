package LibraryManagementSystemPackage;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Book> issuedBooks;
    private List<Book> returnedBooks;

    public User(String name) {
        this.name = name;
        issuedBooks = new ArrayList<>();
        returnedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void addIssuedBook(Book book) {
        issuedBooks.add(book);
    }

    public List<Book> getReturnedBooks() {
        return returnedBooks;
    }

    public void addReturnedBook(Book book) {
        returnedBooks.add(book);
    }
}

