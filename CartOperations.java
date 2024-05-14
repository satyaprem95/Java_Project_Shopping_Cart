// CartOperations.java
public interface CartOperations {
    void addToCart(Item item);
    void removeFromCart(Item item);
    void showCart();
    void clearCart();
    double getTotalAmount();
    void applyCoupon(String coupon);
    double getTax();
    double getPayableAmount();
    void printInvoice();
}