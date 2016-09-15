package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Dbconnector;
import models.UserDetails;

public class UserAddEditDao {
	Connection conn = null;
	PreparedStatement sqlStmt = null;
	
	public void insertUser(String userName,String userAddress,String phoneNumber) throws SQLException {
		try {
			// Get the database connection object
			conn = Dbconnector.getConnection();
			conn.setAutoCommit(false);  
			
			// Execute the sql
			String sql;
			sql = "INSERT INTO UserDetails"
					+ "(user_name,user_address,user_phone) VALUES"
					+ "(?,?,?)";
			sqlStmt = conn.prepareStatement(sql);
			sqlStmt.setString(1, userName);
			sqlStmt.setString(2, userAddress);
			sqlStmt.setString(3, phoneNumber);
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
	
	public UserDetails getUserDetails(int userId)
	{
		UserDetails userDetailsObj = new UserDetails();

        try{
            Connection connection = Dbconnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT user_id, user_name, user_address, user_phone FROM userdetails where user_id = ?");
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	userDetailsObj.setUserId(resultSet.getInt("user_id"));
            	userDetailsObj.setUserName(resultSet.getString("user_name"));
            	userDetailsObj.setUserAddress(resultSet.getString("user_address"));
            	userDetailsObj.setUserPhone(resultSet.getString("user_phone"));
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        return userDetailsObj;
	}
	
	public void editUser(String userName,String userAddress,String phoneNumber,int userId) throws SQLException {
		try {
			// Get the database connection object
			conn = Dbconnector.getConnection();
			conn.setAutoCommit(false);  
			
			// Execute the sql
			String sql;
			sql = "UPDATE userdetails set user_name = ?, user_address = ?, user_phone = ? WHERE user_id = ?";
			sqlStmt = conn.prepareStatement(sql);
			sqlStmt.setString(1, userName);
			sqlStmt.setString(2, userAddress);
			sqlStmt.setString(3, phoneNumber);
			sqlStmt.setInt(4, userId);
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
