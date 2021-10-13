/**
 * 
 */
package it.housework.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.housework.model.User;

/**
 * Gives the CRUD method for the table users: create, retrieve, update and
 * delete 
 * 
 * @author  Matteo Tancredi <matteotank@gmail.com>
 * @version 1.0
 */
public class UsersDAO
{
	/** Object Connection */
	private static Connection conn;
	
	/**
	 * Construct of the class, gives the connection 
	 */
	public UsersDAO () 
	{
		//conn = DBconnect.getConnection();
	}
	
	public User search(String user, String pass)
	{
	    Connection conn = DBconnect.getConnection();
	    
		User result = null;
		
		final String sql = "SELECT tb_users.user, tb_users.admin " +
						   "FROM tb_users WHERE tb_users.user = ? " + 
						   "AND tb_users.pass = ?";
		try {
			 PreparedStatement st = conn.prepareStatement(sql);
	            
	            st.setString(1, user);
	            st.setString(2, pass);
	            
	            ResultSet rs = st.executeQuery();
	            
	            if (rs.next()) {                
	                User us = new User(
	                        rs.getString("user"),
	                        rs.getBoolean("admin")
	                );
	                
	                result = us;
	            } else {
	                result = null;
	            }
	            
	            conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
