package Model;

public class Product {
    private int id;
    private int price;
    private String name;
    private int prodInStock;

    public Product(String name,int price,int prodInStock)
    {
        this.name=name;
        this.price=price;
        this.prodInStock=prodInStock;
    }

    public Product()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProdInStock() {
        return prodInStock;
    }

    public void setProdInStock(int prodInStock) {
        this.prodInStock = prodInStock;
    }

    @Override
    public String  toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", prodInStock=" + prodInStock +
                '}';
    }
}
