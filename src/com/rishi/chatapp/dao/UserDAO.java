package com.rishi.chatapp.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.rishi.chatapp.dto.UserDTO;

// It is doing performs CRUD on USER
public class UserDAO {
	
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException{
		System.out.println("Rec: " + userDTO.getUserid() + "Password: " + userDTO.getPassword());
		// To make connection
		Connection connection = null;
		
		// To do Query using this
		Statement stmt = null;
		
		// Establish connection
		connection = CommonDAO.createConnection();
		
		// Now we will able do Query
		stmt = connection.createStatement();
		int record = stmt.executeUpdate("insert into users(userid, password) values('" +userDTO.getUserid()+"','"+new String(userDTO.getPassword())+"')"); // to do insert , delete , update query
		return record;
	}
}
