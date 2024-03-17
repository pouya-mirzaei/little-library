import java.util.Scanner;

public class LibraryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private final Library library;

    public LibraryApp(Library library) {
        this.library = library;
    }

    public static void main(String[] args) {
        Library library = new Library(); // Initialize Library object
        LibraryApp app = new LibraryApp(library);
        app.run();
    }

    private void run() {
        int choice;

        do {
            displayMenu();
            choice = getIntegerInput("Enter your choice: ");

            switch (choice) {
                case 1:
//                    addBook();
                    break;
                case 2:
//                    registerUser();
                    break;
                case 3:
//                    loginUser();
                    break;
                case 4:
                    // Add functionality for searching books
                    break;
                case 5:
                    System.out.println("Exiting Library App...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    private void displayMenu() {
        System.out.println("\nLibrary Menu:");
        System.out.println("1. Add Book");
        System.out.println("2. Register User");
        System.out.println("3. Login");
        System.out.println("4. Search Books (to be implemented)");
        System.out.println("5. Exit");
    }

    private static int getIntegerInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            scanner.nextLine(); // Clear invalid input
            System.out.print("Invalid input. Please enter a number: ");
        }
        return scanner.nextInt();
    }

    // Implement methods for addBook(), registerUser(), loginUser(), etc.
}
