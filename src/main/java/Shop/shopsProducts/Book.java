package Shop.shopsProducts;

public class Book extends Product {
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public int getBooksId() {
        return id;
    }

    public String getBooksName() {
        return name;
    }

    public int getBooksPrice() {
        return price;
    }

    public String getBooksAuthor() {
        return author;
    }
}
