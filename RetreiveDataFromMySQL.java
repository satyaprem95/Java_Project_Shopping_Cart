import java.sql.*;

public class RetreiveDataFromMySQL {

    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/demodb";
        String user = "root";
        String password = "Satya_468";

        // SQL query to retrieve data
        String query = "SELECT * FROM products";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Process the result set
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                double unitPrice = resultSet.getDouble("unit_price");
                int quantityInStock = resultSet.getInt("quantity_in_stock");

                // Print the retrieved data
                System.out.println("Product ID: " + productId);
                System.out.println("Product Name: " + productName);
                System.out.println("Unit Price: " + unitPrice);
                System.out.println("Quantity in Stock: " + quantityInStock);
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
