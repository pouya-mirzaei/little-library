import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String lastName;
    private final String username;
    private final String password;
    private String role;
    private final byte age;
    private final String gender;
    private Book[] purchasedBooks = new Book[100];

    public User(String id, String name, String lastName, String username, String password, String role, byte age, String gender) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
        this.age = age;
        this.gender = gender;
    }

    public User(String name, String lastName, String username, String password, byte age, String gender) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.role = "USER";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public byte getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getRole() {
        return role;
    }

    public Book[] getPurchasedBooks() {
        return purchasedBooks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public void setRole(String role) {
        if (role.equalsIgnoreCase("admin"))
            this.role = "ADMIN";
        else
            this.role = "USER";
    }

    public boolean isAdmin() {
        return Objects.equals(role, "ADMIN");
    }

}
