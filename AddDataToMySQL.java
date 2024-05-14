import java.sql.*;

public class AddDataToMySQL {

    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/demodb";
        String user = "root";
        String password = "Satya_468";

        // Data to add
        String productNameToAdd = "Olive Oil 1l";
        double unitPrice = 100.0;
        int quantityInStock = 10;

        // SQL query to insert data
        String query = "INSERT INTO products (product_name, unit_price, quantity_in_stock) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameters for the prepared statement
            statement.setString(1, productNameToAdd);
            statement.setDouble(2, unitPrice);
            statement.setInt(3, quantityInStock);

            // Execute the insert operation
            int rowsInserted = statement.executeUpdate();

            // Check if any rows were inserted
            if (rowsInserted > 0) {
                System.out.println("Data added successfully for product: " + productNameToAdd);
            } else {
                System.out.println("Failed to add data for product: " + productNameToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
