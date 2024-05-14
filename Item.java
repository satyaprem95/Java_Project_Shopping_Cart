// Item.java
public class Item {
    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getUnitPrice() * quantity; // Without tax
    }

    @Override
    public String toString() {
        return product.toString() + ", Quantity: " + quantity;
    }
}
