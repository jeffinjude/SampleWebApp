package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.Dbconnector;
import models.UserDetails;

public class UserListDao {
	
	public List<UserDetails> listUsers() throws SQLException {
        List<UserDetails> userDetails = new ArrayList<UserDetails>();

        try{
            Connection connection = Dbconnector.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT user_id, user_name, user_address, user_phone FROM userdetails");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
            	UserDetails userDetailsObj = new UserDetails();
            	userDetailsObj.setUserId(resultSet.getInt("user_id"));
            	userDetailsObj.setUserName(resultSet.getString("user_name"));
            	userDetailsObj.setUserAddress(resultSet.getString("user_address"));
            	userDetailsObj.setUserPhone(resultSet.getString("user_phone"));
            	userDetails.add(userDetailsObj);
            }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        return userDetails;
    }
}
