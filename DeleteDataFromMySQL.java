import java.sql.*;

public class DeleteDataFromMySQL {

    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/demodb";
        String user = "root";
        String password = "Satya_468";

        // Data to delete (example: product name)
        String productNameToDelete = "Olive Oil 1l";

        // SQL query to delete data
        String query = "DELETE FROM products WHERE product_name = ?";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement statement = connection.prepareStatement(query)) {

            // Set parameter for the prepared statement
            statement.setString(1, productNameToDelete);

            // Execute the delete operation
            int rowsDeleted = statement.executeUpdate();

            // Check if any rows were deleted
            if (rowsDeleted > 0) {
                System.out.println("Data deleted successfully for product: " + productNameToDelete);
            } else {
                System.out.println("No product found with name: " + productNameToDelete);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
