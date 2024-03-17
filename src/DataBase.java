import java.io.*;
import java.util.Arrays;

public class DataBase {

    public User[] getUsersFromDb() {
        User[] users = new User[100];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("users.txt"));
            String line;
            int userCounter = 0;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(" ");

                byte age = Byte.parseByte(userData[6]);

                User user = new User(userData[0], userData[1], userData[2], userData[3], userData[4], userData[5], age, userData[7]);

                users[userCounter] = user;
                userCounter++;
            }
            reader.close();

        } catch (IOException e) {
            updateUsersDb(new User[100]);
            return getUsersFromDb();
        }


        return users;
    }


    public void updateUsersDb(User[] users) {
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter("users.txt"));
            for (User user : users) {
                if (user == null) continue;

                writer.write(user.getId() + " ");
                writer.write(user.getName() + " ");
                writer.write(user.getLastName() + " ");
                writer.write(user.getUsername() + " ");
                writer.write(user.getPassword() + " ");
                writer.write(user.getRole() + " ");
                writer.write(user.getAge() + " ");
                writer.write(user.getGender() + " \n");


            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public Book[] getBooksFromDb() {
        Book[] books = new Book[100];
        try {
            BufferedReader reader = new BufferedReader(new FileReader("books.txt"));
            String line;
            int bookCounter = 0;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(" ");


                Book book = new Book(bookData[0], bookData[1], Integer.parseInt(bookData[2]), Double.parseDouble(bookData[3]), Integer.parseInt(bookData[4]));

                books[bookCounter] = book;
                bookCounter++;
            }
            reader.close();

        } catch (IOException e) {
            updateBooksDb(new Book[100]);
            return getBooksFromDb();
        }


        return books;
    }


    public void updateBooksDb(Book[] books) {
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter("books.txt"));
            for (Book book : books) {
                if (book == null) continue;

                writer.write(book.getId() + " ");
                writer.write(book.getTitle() + " ");
                writer.write(book.getAuthor() + " ");
                writer.write(book.getPublishedYear() + " ");
                writer.write(book.getPrice() + " ");
                writer.write(book.getQuantity() + " \n");

            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
