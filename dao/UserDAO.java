package dao;
import model.UserBean;
import java.sql.*;

public class UserDAO {
    
    // Method 1: Login - Validate Email and Password
    public boolean validateLogin(UserBean user) {
        boolean status = false;
        
        // Example SQL: Change "users_table" to your actual table name
        String sql = "SELECT * FROM users_table WHERE email = ? AND password = ?";
        
        try {
            // Add your Database connection code here
            // Connection con = ... 
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            
            ResultSet rs = ps.executeQuery();
            status = rs.next(); // Returns true if a match is found in the database
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    // Method 2: Dashboard - Get Total Students
    public int getTotalStudents() {
        int count = 0;
        String sql = "SELECT COUNT(*) FROM students_table"; // Update table name
        try {
            // Add DB Connection here
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
    
    // Create similar methods for getTotalPortfolios(), getTotalAssets(), etc.
}
