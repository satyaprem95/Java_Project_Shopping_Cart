import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class gui extends JFrame implements ActionListener {

    private JTextArea outputArea;
    private JComboBox<String> itemComboBox;
    private JSpinner quantitySpinner;
    private ShoppingCart cart;

    private String[] itemNames = {"Olive Oil 1l", "Cheese Slices", "Bread", "Eggs", "Chicken Salami"};
    private double[] itemPrices = {100.0, 50.0, 75.0, 10.0, 100.0};
    private int[] itemQuantities = {10, 20, 15, 100, 5};

    public gui() {
        setTitle("Shopping Cart");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        JPanel inputPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        itemComboBox = new JComboBox<>(itemNames);
        quantitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, null, 1));
        JButton addToCartButton = new JButton("Add to Cart");
        JButton showCartButton = new JButton("Show Cart");
        JButton clearCartButton = new JButton("Clear Cart");
        JButton printInvoiceButton = new JButton("Print Invoice");
        JButton exitButton = new JButton("Exit");

        inputPanel.add(itemComboBox);
        inputPanel.add(quantitySpinner);
        inputPanel.add(addToCartButton);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        buttonPanel.add(showCartButton);
        buttonPanel.add(clearCartButton);
        buttonPanel.add(printInvoiceButton);
        buttonPanel.add(exitButton);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);

        cart = new ShoppingCart();
        addToCartButton.addActionListener(this);
        showCartButton.addActionListener(this);
        clearCartButton.addActionListener(this);
        printInvoiceButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "Add to Cart":
                addToCart();
                break;
            case "Show Cart":
                showCart();
                break;
            case "Clear Cart":
                clearCart();
                break;
            case "Print Invoice":
                printInvoice();
                break;
            case "Exit":
                exitProgram();
                break;
        }
    }

    private void addToCart() {
        String itemName = (String) itemComboBox.getSelectedItem();
        int itemIndex = itemComboBox.getSelectedIndex();
        int quantity = (int) quantitySpinner.getValue();

        if (quantity > itemQuantities[itemIndex]) {
            outputArea.append("Sorry, we only have " + itemQuantities[itemIndex] + " " + itemName + " available.\n");
        } else {
            Product product = new Product(itemName, itemPrices[itemIndex], quantity);
            Item item = new Item(product, quantity);
            cart.addToCart(item);
            outputArea.append("Item added to cart: " + item + "\n");
        }
    }

    private void showCart() {
        outputArea.append("Items in cart:\n");
        cart.showCart();
    }

    private void clearCart() {
        cart.clearCart();
        outputArea.setText("Cart cleared.\n");
    }

    private void printInvoice() {
    	cart.printInvoice();
    }

    private void exitProgram() {
        System.exit(0);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new gui().setVisible(true);
        });
    }
}