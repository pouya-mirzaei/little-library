import java.util.Objects;

public class Library {
    User[] users;

    public Library() {
        users = App.db.getUsersFromDb();

//        User mainAdmin = new User("admin", "mirzaei", "admin", "admin1234", (byte) 19, "male");
//        mainAdmin.setRole("ADMIN");
//        users[0] = mainAdmin;

//        App.db.getUsersFromDb();
        App.db.updateUsersDb(users);

    }

    public void addUser(User user) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                App.db.updateUsersDb(users);
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
