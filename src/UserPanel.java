import java.util.Scanner;

public class UserPanel {
    Typewriter tw = App.tw;
    Scanner scanner = App.scanner;

    public void start() {
        Menu.clearScreen();
        tw.type("User menu");
        tw.type("Welcome " + Authentication.currenUserData.getName() + " " + Authentication.currenUserData.getLastName());
        tw.type("This is the normal user panel");

    }
}
