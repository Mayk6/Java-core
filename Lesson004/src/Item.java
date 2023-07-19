import Enums.ProdCategories;

public class Item {

    private String name;
    private double price;
    private ProdCategories categories;

    public Item(String name, double price, ProdCategories categories) {
        this.name = name;
        this.price = price;
        this.categories = categories;
    }

    public ProdCategories getCategories() {
        return categories;
    }

    public void setCategories(ProdCategories categories) {
        this.categories = categories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
