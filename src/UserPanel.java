import java.util.Scanner;

public class UserPanel {
    Typewriter tw = App.tw;
    Scanner scanner = App.scanner;

    public void start() {
        String[] menuItems = {"Buy a book from library", "My Books", "Logout"};
        int userInput = 0;

        String message = "User menu\n";
        message += "Welcome " + Authentication.currenUserData.getName() + " " + Authentication.currenUserData.getLastName();

        do {
            App.menu.displayMenu(menuItems, message + "\n\nWhat are we up to?");

            userInput = App.getIntegerInput();
        } while (userInput < 1 || userInput > menuItems.length);

        switch (userInput) {
            case 1:
                buyBook();
                break;
            case 2:
                myAccount();
                break;
            case 3:
                Authentication.logout();
                App.run();
                break;

        }

    }

    private void myAccount() {
        Menu.clearScreen();
        tw.type("The list of your books=>");
        Book[] userBooks = Authentication.currenUserData.getPurchasedBooks();

        System.out.println("\n** My Books **");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf("%-40s %-20s %-20s %-10s %-10s\n", "Title", "Author", "Published Year", "Price", "Quantity");
        System.out.println("-------------------------------------------------------------------------------------------------------");

        for (Book book : userBooks) {
            if (book == null) continue;
            System.out.printf("%-40s %-20s %-20d %-10.2f %-10d\n",
                    book.getTitle(), book.getAuthor(), book.getPublishedYear(), book.getPrice(), book.getQuantity());
        }
        System.out.println("-------------------------------------------------------------------------------------------------------");

        tw.type("Press any key to continue ...");
        scanner.next();

        App.run();

    }

    private void buyBook() {
        Menu.clearScreen();
        if (App.library.books[0] == null) {
            tw.type("Sorry , there is no book in the library to purchase right now :(");
            try {
                Thread.sleep(8000);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
            start();
            return;
        }

        App.library.showAllBooks();
        tw.type("Which one of the books do you want to buy?");
        tw.type("Enter the name of the book=>");

        String title = scanner.next();
        Book selectedBook = App.library.findbook(title);

        while (selectedBook == null) {
            tw.type("Please write the title of the book correct!");
            title = scanner.next();
            selectedBook = App.library.findbook(title);
        }

        if (selectedBook.getQuantity() < 1) {
            tw.type("The selected book is not available, try in another time");
            tw.type("Returning the previous menu...");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                //
            }
            start();
        }

        tw.type("Buying " + selectedBook.getTitle() + " from " + selectedBook.getAuthor() + " ...");
        selectedBook.decreaseQuantity();
        App.library.purchaseBook(Authentication.currentUserId, selectedBook);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        tw.type("The book had been purchased successfully !");
        tw.type("Returning to the main menu...");

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            //
        }

        App.run();


    }
}
