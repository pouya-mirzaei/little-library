import java.util.UUID;

public class Book {

    private String id;
    private String title;
    private String author;
    private int publishedYear;
    private double price;
    private int quantity;


    public Book(String title, String author, int publishedYear, double price, int quantity) {
        this.id = String.valueOf(UUID.randomUUID());
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
        this.quantity = quantity;
    }

    public Book(String id, String title, String author, int publishedYear, double price, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id.substring(0, 6);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
