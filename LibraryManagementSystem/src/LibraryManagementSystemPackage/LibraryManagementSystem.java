package LibraryManagementSystemPackage;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.println("Welcome to the Library Management System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Available Books");
            System.out.println("6. View Issued Books");
            System.out.println("7. View Returned Books");
            System.out.println("8. View Users");
            System.out.println("9. View All Books");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter book title:");
                    String title = scanner.next();
                    System.out.println("Enter book author:");
                    String author = scanner.next();
                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.println("Enter user name:");
                    String userName = scanner.next();
                    library.addUser(userName);
                    break;
                case 3:
                    System.out.println("Enter user name:");
                    String issueUserName = scanner.next();

                    // Step 1: User Identification
                    User issueUser = null;
                    for (User user : library.users) {
                        if (user.getName().equals(issueUserName)) {
                            issueUser = user;
                            break;
                        }
                    }

                    if (issueUser == null) {
                        System.out.println("User not found.");
                        break;
                    }

                    System.out.println("Enter book title:");
                    String issueBookTitle = scanner.next();

                    // Step 2: Book Identification
                    Book issueBook = null;
                    for (Book book : library.books) {
                        if (book.getTitle().equals(issueBookTitle) && book.isAvailable()) {
                            issueBook = book;
                            break;
                        }
                    }

                    if (issueBook == null) {
                        System.out.println("Book not found or not available.");
                        break;
                    }

                    // Step 3: Issuing the Book
                    library.issueBook(issueUser, issueBook);
                    break;

                case 4:
                    System.out.println("Enter user name:");
                    String returnUserName = scanner.next();

                    User returnUser=null;
                    for (User user : library.users){
                        if(user.getName().equals(returnUserName)){
                            returnUser=user;
                            break;
                        }
                    }
                    if (returnUser==null){
                        System.out.println("User not found");
                        break;

                    }
                    System.out.println("Enter book title :");
                    String returnBooktitle=scanner.next();

                   Book returnbook=null;
                    for (Book book : library.books){
                        if (book.getTitle().equals(returnBooktitle)){
                            returnbook=book;
                            break;

                        }
                    }
                    if (returnbook==null){
                        System.out.println("Book not issued by this  user.");
                    }
                    library.returnBook(returnUser,returnbook);

                    break;
                case 5:
                    library.viewAvailableBooks();
                    break;
                case 6:
                    System.out.println("Enter user name:");
                    String viewIssuedUserName = scanner.next();
                    User viewIssuedUser = library.users.stream().filter(u -> u.getName().equals(viewIssuedUserName)).findFirst().orElse(null);
                    if (viewIssuedUser == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    library.viewIssuedBooks(viewIssuedUser);
                    break;
                case 7:
                    System.out.println("Enter user name:");
                    String viewReturnedUserName = scanner.next();
                    User viewReturnedUser = library.users.stream().filter(u -> u.getName().equals(viewReturnedUserName)).findFirst().orElse(null);
                    if (viewReturnedUser == null) {
                        System.out.println("User not found.");
                        break;
                    }
                    library.viewReturnedBooks(viewReturnedUser);
                    break;
                case 8:
                    library.viewUsers();
                    break;
                case 9:
                    library.viewAllBooks();
                    break;

                case 0:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    System.exit(0);


                default:
                    System.out.println("Invalid option. Please choose a valid option from the menu.");
                    break;
            }
        }
    }
}
