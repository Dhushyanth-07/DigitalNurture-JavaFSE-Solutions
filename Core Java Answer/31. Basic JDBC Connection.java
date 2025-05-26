import java.sql.*;

public class JdbcDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/community_portal";
        String username = "root";
        String password = "password";
        
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database");
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");
            
            while (resultSet.next()) {
                System.out.println(resultSet.getString("full_name"));
            }
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}