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
                continue;
            }
            if (Objects.equals(users[i].getUsername(), username)) {
                return users[i];
            }
        }
        return null;
    }

    public int getUserIndex(String username) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                continue;
            }
            if (Objects.equals(users[i].getUsername(), username)) {
                return i;
            }
        }
        return -1;
    }


    public User[] getUsers() {
        return users;
    }

    public void showAllUsers() {
        System.out.println("\n** All Users **");
        System.out.println("---------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-10s %-10s %-15s\n", "ID", "Name", "Username", "Age", "Gender", "Role");
        System.out.println("---------------------------------------------------------------------------------");

        // Loop through all users and display their information
        for (User user : users) {
            if (user == null) continue;
            
            System.out.printf("%-20s %-20s %-20s %-10d %-10s %-15s\n",
                    user.getId(), user.getFullName(), user.getUsername(), user.getAge(), user.getGender(), user.getRole());
        }
        System.out.println("---------------------------------------------------------------------------------");


    }


}
