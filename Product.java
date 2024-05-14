// Product.java
public class Product {
    private String productName;
    private double unitPrice;
    private int quantityInStock;

    public Product(String productName, double unitPrice, int quantityInStock) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }

    public String getProductName() {
        return productName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return productName + " (Price: $" + unitPrice + ")";
    }
}
