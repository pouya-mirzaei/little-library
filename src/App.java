import javax.swing.*;
import java.util.Scanner;

public class App {

    public static Scanner scanner = new Scanner(System.in);
    public static Typewriter tw = new Typewriter(15);

    Menu menu = new Menu();

    public App(Library library) {
        // Initializing the project
    }

    public static void main(String[] args) {
        Library library = new Library();
        App app = new App(library);
        app.run();
    }

    public static int getIntegerInput() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine(); // Clear invalid input
            tw.type("Invalid input. Please enter a number: ");
        }
        return scanner.nextInt();

    }

    private void run() {
        String[] mainMenu = {"Login", "Password"};
        int userInput = 0;

        do {
            menu.displayMenu(mainMenu, "Select an option to continue");
            userInput = getIntegerInput();
        } while (userInput < 1 || userInput > mainMenu.length);


    }

}
