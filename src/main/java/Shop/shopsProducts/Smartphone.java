package Shop.shopsProducts;

public class Smartphone extends Product {
    private String creator;

    public Smartphone(int id, String name, int price, String creator) {
        super(id, name, price);
        this.creator = creator;
    }
    public int getSmartphonesId() {
        return id;
    }

    public String getSmartphonesName() {
        return name;
    }

    public int getSmartphonesPrice() {
        return price;
    }

    public String getSmartphonesCreator() {
        return creator;
    }
}
