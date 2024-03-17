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

        } catch (IOException e) {
            throw new RuntimeException(e);
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
}
