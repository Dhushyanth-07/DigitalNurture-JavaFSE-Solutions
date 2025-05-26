import java.sql.*;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/community_portal";
    private static final String USER = "root";
    private static final String PASS = "password";
    
    public void insertStudent(String name, String email) throws SQLException {
        String sql = "INSERT INTO Users (full_name, email) VALUES (?, ?)";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
        }
    }
    
    public void updateStudent(int id, String newName) throws SQLException {
        String sql = "UPDATE Users SET full_name = ? WHERE user_id = ?";
        
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, newName);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }
}