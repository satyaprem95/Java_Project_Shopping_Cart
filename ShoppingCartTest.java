import java.util.Scanner;

public class ShoppingCartTest {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        // Simulate items available in the store
        Product p1 = new Product("Olive Oil 1l", 100.0, 10);
        Product p2 = new Product("Cheese Slices", 50.0, 20);
        Product p3 = new Product("Bread", 75.0, 15);
        Product p4 = new Product("Eggs", 10.0, 100);
        Product p5 = new Product("Chicken Salami", 100.0, 5);

        System.out.println("Welcome to the store! Here are the available items:");
        System.out.println("1. " + p1 + ", Available: " + p1.getQuantityInStock());
        System.out.println("2. " + p2 + ", Available: " + p2.getQuantityInStock());
        System.out.println("3. " + p3 + ", Available: " + p3.getQuantityInStock());
        System.out.println("4. " + p4 + ", Available: " + p4.getQuantityInStock());
        System.out.println("5. " + p5 + ", Available: " + p5.getQuantityInStock());
        System.out.println("Enter 'checkout' to proceed to checkout.");
        System.out.println("Enter 'show' to see items added so far.");
        System.out.println("Enter 'clear' to clear your cart.");

        while (true) {
            System.out.print("Enter the number of the item you want to add to cart: ");
            String input = scanner.nextLine();

            if (input.equals("checkout")) {
                System.out.println("You have chosen to checkout. Here is your final invoice:");
                cart.printInvoice();
                break;
            } else if (input.equals("show")) {
                System.out.println("Items in cart:");
                cart.showCart();
                continue;
            } else if (input.equals("clear")) {
                cart.clearCart();
                continue;
            }

            try {
                int choice = Integer.parseInt(input);
                Product selectedProduct;
                switch (choice) {
                    case 1:
                        selectedProduct = p1;
                        break;
                    case 2:
                        selectedProduct = p2;
                        break;
                    case 3:
                        selectedProduct = p3;
                        break;
                    case 4:
                        selectedProduct = p4;
                        break;
                    case 5:
                        selectedProduct = p5;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                        continue;
                }

                System.out.print("Enter the quantity: ");
                int quantity = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                if (quantity > selectedProduct.getQuantityInStock()) {
                    throw new InsufficientStockException("Sorry, we only have " + selectedProduct.getQuantityInStock() + " " + selectedProduct.getProductName() + " available.");
                }

                Item item = new Item(selectedProduct, quantity);
                cart.addToCart(item);
                System.out.println("Enter 'checkout' to proceed to checkout or 'show' to see items added so far.");

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'checkout'.");
            } catch (InsufficientStockException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}

