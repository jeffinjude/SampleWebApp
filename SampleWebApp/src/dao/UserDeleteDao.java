package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import database.Dbconnector;

public class UserDeleteDao {
	Connection conn = null;
	PreparedStatement sqlStmt = null;
	
	public void deleteUser(int userId)
	{
		try {
			// Get the database connection object
			conn = Dbconnector.getConnection();
			conn.setAutoCommit(false);  
			
			// Execute the sql
			String sql;
			sql = "DELETE FROM UserDetails WHERE user_id = ?";
			sqlStmt = conn.prepareStatement(sql);
			sqlStmt.setInt(1, userId);
			sqlStmt.executeUpdate();
			conn.commit();
			
			// Clean-up environment
			sqlStmt.close();
			conn.close();
		}
		catch (Exception e) {
			//Rollback sql
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		} 
		finally {
			// finally block used to close resources
			try {
				if (sqlStmt != null)
					sqlStmt.close();
			} catch (SQLException se2) {
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try
	}
}
