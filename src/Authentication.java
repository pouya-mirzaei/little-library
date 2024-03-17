import java.util.Objects;

public class Authentication {
    public static boolean isUserLoggedIn = false;
    public static String currentUserId = null;
    public static User currenUserData = null;


    public void login(String username, String password) {
        User[] users = App.library.getUsers();

        for (User user : users) {
            if (user != null) {
                if (Objects.equals(user.getUsername(), username)) {
                    if (Objects.equals(user.getPassword(), password)) {
                        isUserLoggedIn = true;
                        currentUserId = user.getId();
                        currenUserData = user;
                        App.tw.type("You logged in to your account successfully !");
                        App.tw.type("Press any key to continue ...");
                        App.scanner.next();
                        App.run();
                        return;

                    } else {
                        Menu.clearScreen();
                        App.tw.type("The username or password is incorrect");
                        App.tw.type("To try again press 0");
                        App.tw.type("To go back to the main menu press -1");
                        String input = App.scanner.next();
                        if (Objects.equals(input, "0")) {
                            App.loginMenu();
                        } else {
                            App.run();
                            return;
                        }
                    }
                }

            } else {
                return;
            }
        }

    }

    public void signup(String name, String lastName, String username, String password, byte age, String gender) {
        User newUser = new User(name, lastName, username, password, age, gender);
        App.library.addUser(newUser);

        App.tw.type("You have successfully registered in our app :)");
        App.tw.type("Press any key to continue ...");
        App.scanner.next();
        App.run();
    }

    public void logout() {
        isUserLoggedIn = false;
        currentUserId = null;
        currenUserData = null;

    }

}
