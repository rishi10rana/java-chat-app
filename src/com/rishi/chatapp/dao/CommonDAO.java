package com.rishi.chatapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.rishi.chatapp.utils.ConfigReader.getValue;

public class CommonDAO {
	public Connection createConnection() throws ClassNotFoundException, SQLException {
		// Step - Load the Driver Class
		Class.forName(getValue("DRIVER"));

		// Step 2 - Making a Connection
		final String CONNECTION_STRING = getValue("CONNECTION_URL");
		final String USER_ID = getValue("USERID");
		final String PASSWORD = getValue("PASSWORD");
		Connection con = DriverManager.getConnection(CONNECTION_STRING, USER_ID, PASSWORD);
		
		if(con!=null){
			System.out.println("Connection Created...");
			con.close();
		}
		return null;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		CommonDAO commonDAO = new CommonDAO();
		commonDAO.createConnection();
	}
}
