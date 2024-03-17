import java.util.Objects;
import java.util.Scanner;

public class Library {
    Typewriter tw = App.tw;
    Scanner scanner = App.scanner;
    User[] users;
    Book[] books;

    public Library() {
        users = App.db.getUsersFromDb();
        books = App.db.getBooksFromDb();
        App.db.updateUsersDb(users);

    }

    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                App.db.updateUsersDb(users);
                return;
            }
        }

    }

    public User findUser(String username) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                continue;
            }
            if (Objects.equals(users[i].getUsername(), username)) {
                return users[i];
            }
        }
        return null;
    }

    public User findUserById(String id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                continue;
            }
            if (Objects.equals(users[i].getId(), id)) {
                return users[i];
            }
        }
        return null;
    }

    public int getUserIndex(String username) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                continue;
            }
            if (Objects.equals(users[i].getUsername(), username)) {
                return i;
            }
        }
        return -1;
    }

    public int getBookIndex(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                continue;
            }
            if (Objects.equals(books[i].getTitle(), title)) {
                return i;
            }
        }
        return -1;
    }


    public User[] getUsers() {
        return users;
    }

    public void showAllUsers() {
        System.out.println("\n** All Users **");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-10s %-10s %-15s\n", "ID", "Name", "Username", "Age", "Gender", "Role");
        System.out.println("--------------------------------------------------------------------------------------------");

        // Loop through all users and display their information
        for (User user : users) {
            if (user == null) continue;

            System.out.printf("%-20s %-20s %-20s %-10d %-10s %-15s\n",
                    user.getId(), user.getFullName(), user.getUsername(), user.getAge(), user.getGender(), user.getRole());
        }
        System.out.println("--------------------------------------------------------------------------------------------");


    }

    public void showAllBooks() {
        System.out.println("\n** All Books **");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("%-40s %-20s %-20s %-10s %-10s\n", "Title", "Author", "Published Year", "Price", "Quantity");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        for (Book book : books) {
            if (book == null) continue;
            System.out.printf("%-40s %-20s %-20d %-10.2f %-10d\n",
                    book.getTitle(), book.getAuthor(), book.getPublishedYear(), book.getPrice(), book.getQuantity());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }


    public void addNewBook() {
        Menu.clearScreen();
        scanner.nextLine();
        tw.type("Signup Menu Menu");

        // book
        tw.type("Enter the title of the book =>");
        String title = scanner.next();

        // author
        tw.type("Enter the author of the book =>");
        String author = scanner.next();

        // pl
        tw.type("Enter the published year of the book =>");
        int pl = App.getIntegerInput();

        // price
        tw.type("Enter the price of the book =>");
        Double price = (double) App.getIntegerInput();

        // quantity
        tw.type("Enter the quantity of the book =>");
        int quantity = App.getIntegerInput();

        Book newBook = new Book(title, author, pl, price, quantity);
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = newBook;
                App.db.updateBooksDb(books);
                return;
            }
        }

    }


    public Book findbook(String title) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                continue;
            }
            if (Objects.equals(books[i].getTitle(), title)) {
                return books[i];
            }
        }
        return null;
    }


    public void purchaseBook(String userId, Book book) {
        User user = findUserById(userId);
        Book[] userBooks = user.getPurchasedBooks();
        for (int i = 0; i < userBooks.length; i++) {
            if (userBooks[i] == null) {
                userBooks[i] = book;
                App.db.updateBooksDb(App.library.books);
                return;
            }
        }
    }

}
