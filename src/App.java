import javax.swing.*;
import java.util.Objects;
import java.util.Scanner;

public class App {

    public static Scanner scanner;
    public static Typewriter tw;
    public static Library library;

    static Authentication auth;
    static Menu menu;

    public App() {
        scanner = new Scanner(System.in);
        tw = new Typewriter(15);
        auth = new Authentication();
        library = new Library();
        menu = new Menu();

    }


    public static int getIntegerInput() {
        while (!scanner.hasNextInt()) {
            scanner.nextLine(); // Clear invalid input
            tw.type("Invalid input. Please enter a number: ");
        }
        return scanner.nextInt();

    }


    public static void run() {
        if (auth.isUserLoggedIn) {
            if (auth.currenUserData.isAdmin()) {
                adminMenu();
            } else {
                userMenu();
            }
        } else {
            authenticateUser();
        }


    }

    private static void userMenu() {
        tw.type("User menu");

    }

    private static void adminMenu() {
        tw.type("Admin menu");

    }

    private static void authenticateUser() {
        String[] mainMenu = {"Login", "Sign Up", "Exit"};
        int userInput = 0;

        do {
            menu.displayMenu(mainMenu, "Select an option to continue");
            userInput = getIntegerInput();
        } while (userInput < 1 || userInput > mainMenu.length);


        switch (userInput) {
            case 1:
                loginMenu();
                break;
            case 2:
                signupMenu();
                break;
            case 3:
                break;

        }
    }


    public static void loginMenu() {
        Menu.clearScreen();
        tw.type("Login Menu");

        tw.type("Enter your username =>");
        String username = scanner.next();

        tw.type("Enter your password =>");
        String password = scanner.next();

        auth.login(username, password);
    }

    private static void signupMenu() {
        Menu.clearScreen();
        tw.type("Signup Menu Menu");

        // name
        tw.type("Enter your name =>");
        String name = scanner.next();

        // last name
        tw.type("Enter your last name =>");
        String lastName = scanner.next();

        // username
        tw.type("Enter your username =>");
        String username = scanner.next();

        if (App.library.findUser(username) != null) {
            do {
                tw.type("The username \"" + username + "\" is already in use. Please try a different username.");
                username = scanner.next();

            } while (App.library.findUser(username) != null);
        }

        // password
        tw.type("Enter your password =>");
        String password = scanner.next();

        // age
        tw.type("Enter your age =>");
        byte age = (byte) getIntegerInput();

        // gender
        int userInput = 0;
        String gender;

        do {
            menu.displayMenu(new String[]{"male", "female"}, "Select your gender =>");
            userInput = getIntegerInput();
        } while (userInput < 1 || userInput > 2);
        gender = userInput == 1 ? "male" : "female";


        auth.signup(name, lastName, username, password, age, gender);
     

    }

}
