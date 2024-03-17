import java.util.Scanner;

public class AdminPanel {
    Typewriter tw = App.tw;
    Scanner scanner = App.scanner;

    public void start() {
        String[] menuItems = {"Library Settings", "Users Settings", "Logout"};
        int userInput = 0;

        String message = "Admin menu\n";
        message += "Welcome " + Authentication.currenUserData.getName() + " " + Authentication.currenUserData.getLastName();

        do {
            App.menu.displayMenu(menuItems, message + "\n\nWhat do you want to do ?");

            userInput = App.getIntegerInput();
        } while (userInput < 1 || userInput > menuItems.length);

        switch (userInput) {
            case 1:
                libSettingsMenu();
                break;
            case 2:
                usersSettingsMenu();
                break;
            case 3:
                Authentication.logout();
                App.run();
                break;

        }

    }

    private void libSettingsMenu() {

        String[] menuItems = {"Show all Books", "Add a new book to the library", "Delete a book", "Edit a book", "back"};
        int userInput = 0;

        do {
            App.menu.displayMenu(menuItems, "Library Settings :\n\nChoose an option =>");

            userInput = App.getIntegerInput();
        } while (userInput < 1 || userInput > menuItems.length);
    }


    // users settings section
    private void usersSettingsMenu() {

        String[] menuItems = {"Show all users", "Delete a user", "Upgrade a user", "back"};
        int userInput = 0;

        do {
            App.menu.displayMenu(menuItems, "Users Settings :\n\nChoose an option =>");

            userInput = App.getIntegerInput();
        } while (userInput < 1 || userInput > menuItems.length);


        switch (userInput) {
            case 1:
                Menu.clearScreen();
                App.library.showAllUsers();
                tw.type("Press Any key to go back");
                scanner.next();
                usersSettingsMenu();
                break;
            case 2:
                Menu.clearScreen();
                deleteUser();
                break;
            case 3:
                Menu.clearScreen();
                upgradeUser();
                break;
            case 4:
                this.start();
        }

    }

    private void upgradeUser() {
        tw.type("Enter the username of the user that you want to upgrade");

        String username = scanner.next();
        User user = App.library.findUser(username);

        if (user == null) {
            tw.type("There is no user in the this app with the username of " + username);
            tw.type("Press 0 to search for a user");
            tw.type("Press -1 to go back");

            int userInput;

            do {
                userInput = App.getIntegerInput();
            } while (userInput != 0 && userInput != -1);

            if (userInput == 0) {
                Menu.clearScreen();
                upgradeUser();
            } else {
                usersSettingsMenu();
            }

        } else {
            tw.type("Are you sure you want to upgrade " + user.getFullName() + " ?");
            scanner.next();

            App.library.users[App.library.getUserIndex(username)].setRole("ADMIN");

            App.db.updateUsersDb(App.library.getUsers());

            tw.type("User " + user.getUsername() + " is now an admin");
            scanner.next();

            usersSettingsMenu();

        }
    }

    private void deleteUser() {

        tw.type("Enter the username of the user that you want to be deleted");

        String username = scanner.next();
        User user = App.library.findUser(username);
        if (user == null) {
            tw.type("There is no user in the this app with the username of " + username);
            tw.type("Press 0 to try again");
            tw.type("Press -1 to go back");

            int userInput;

            do {
                userInput = App.getIntegerInput();
            } while (userInput != 0 && userInput != -1);

            if (userInput == 0) {
                Menu.clearScreen();
                deleteUser();
            } else {
                usersSettingsMenu();
            }

        } else {
            tw.type("Are you sure you want to delete " + user.getFullName() + " ?");
            scanner.next();

            App.library.users[App.library.getUserIndex(username)] = null;

            App.db.updateUsersDb(App.library.getUsers());

            tw.type("User " + user.getFullName() + " deleted any way");
            tw.type("Press any key to go back ...");
            scanner.next();

            usersSettingsMenu();

        }

    }

}
