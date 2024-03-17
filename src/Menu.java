import java.io.IOException;

public class Menu {
    Typewriter tw = App.tw;

    public void displayMenu(String[] menuItems, String message){
        clearScreen();
        tw.type(message);
        int counter = 1;

        for (String item : menuItems){
            tw.type(" "+ counter+ ". " + item);
            counter++;
        }


    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }

            // Now your console is cleared
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
