import java.util.Objects;

public class Library {
    User[] users = new User[100];

    public Library() {
        User mainAdmin = new User("admin", "mirzaei", "admin", "admin1234", (byte) 19, "male");
        mainAdmin.setRole("ADMIN");
        users[0] = mainAdmin;


    }

    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return;
            }
        }

    }

    public User findUser(String username) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                return null;
            }
            if (Objects.equals(users[i].getUsername(), username)) {
                return users[i];
            }
        }
        return null;
    }

    public User[] getUsers() {
        return users;
    }
}
