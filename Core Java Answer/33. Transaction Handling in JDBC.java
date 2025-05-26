import java.sql.*;

public class BankTransfer {
    private static final String URL = "jdbc:mysql://localhost:3306/bank";
    private static final String USER = "root";
    private static final String PASS = "password";
    
    public static void transfer(int fromAccount, int toAccount, double amount) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            conn.setAutoCommit(false);
            
            // Debit from account
            PreparedStatement debit = conn.prepareStatement(
                "UPDATE accounts SET balance = balance - ? WHERE account_id = ?");
            debit.setDouble(1, amount);
            debit.setInt(2, fromAccount);
            debit.executeUpdate();
            
            // Credit to account
            PreparedStatement credit = conn.prepareStatement(
                "UPDATE accounts SET balance = balance + ? WHERE account_id = ?");
            credit.setDouble(1, amount);
            credit.setInt(2, toAccount);
            credit.executeUpdate();
            
            conn.commit();
            System.out.println("Transfer successful");
        } catch (SQLException e) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            System.out.println("Transfer failed: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}