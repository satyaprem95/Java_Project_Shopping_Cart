import java.sql.*;

public class UpdateProductsTable {

    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/demodb";
        String user = "root";
        String password = "Satya_468";

        // Data to update
        String productNameToUpdate = "Olive Oil 1l"; // Example product name to update
        int newQuantityInStock = 10; // New quantity in stock after adding to cart

        // SQL query to update quantity_in_stock
        String query = "UPDATE products SET quantity_in_stock = ? WHERE product_name = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameters for the prepared statement
            statement.setInt(1, newQuantityInStock);
            statement.setString(2, productNameToUpdate);

            // Execute the update operation
            int rowsUpdated = statement.executeUpdate();

            // Check if the update was successful
            if (rowsUpdated > 0) {
                System.out.println("Data updated successfully for product: " + productNameToUpdate);
            } else {
                System.out.println("No product found with name: " + productNameToUpdate);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
