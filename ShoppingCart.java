// ShoppingCart.java
import java.text.DecimalFormat;
import java.util.ArrayList;

public class ShoppingCart implements CartOperations {
    private ArrayList<Item> items;
    private double totalAmount;
    private double payableAmount;
    private double discount;
    private double tax;
    private String coupon;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.coupon = "";
        this.totalAmount = 0;
        this.payableAmount = 0;
        this.discount = 0;
        this.tax = 0;
    }
    

    @Override
    public void addToCart(Item item) {
        items.add(item);
        System.out.println("Item added to cart: " + item);
    }

    @Override
    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("No items in cart");
            return;
        }
        for (Item item : items) {
            System.out.println(item);
        }
    }

    @Override
    public void clearCart() {
        items.clear();
        System.out.println("Cart cleared");
    }

    @Override
    public double getTotalAmount() {
        double totalAmount = 0;
        for (Item item : items) {
            totalAmount += item.getTotalPrice();
        }
        return totalAmount;
    }

    @Override
    public void applyCoupon(String coupon) {
        this.coupon = coupon;
        if (coupon.equals("IND10")) {
            this.discount = this.getTotalAmount() * 0.1;
        } else {
            this.discount = 0; // No discount for other coupons
        }
    }

    @Override
    public double getTax() {
        return this.getTotalAmount() * 0.05; // 5% tax of the total amount
    }

    @Override
    public double getPayableAmount() {
        this.tax = this.getTax();
        this.payableAmount = this.getTotalAmount() - this.discount + this.tax;
        return this.payableAmount;
    }

    @Override
    public void printInvoice() {
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("=================================================================");
        System.out.println("                          INVOICE                                ");
        System.out.println("=================================================================");
        System.out.println("Product\t\t\tQuantity\tUnit Price\tTotal Amount");
        System.out.println("-----------------------------------------------------------------");
        for (Item item : items) {
            System.out.printf("%-20s\t%d\t\t$%.2f\t\t$%.2f\n", item.getProduct().getProductName(), item.getQuantity(), item.getProduct().getUnitPrice(), item.getTotalPrice());
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\t\t\t\t\tTotal: $" + df.format(getTotalAmount()));
        System.out.println("\t\t\t\t\tDiscount: $" + df.format(discount));
        System.out.println("\t\t\t\t\tTax: $" + df.format(getTax()));
        System.out.println("\t\t\t\t\tTotal Payable: $" + df.format(getPayableAmount()));
        System.out.println("=================================================================");
        
    }

}

