package com.rishi.chatapp.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.rishi.chatapp.dto.UserDTO;
import com.rishi.chatapp.utils.Encryption;

// It is doing performs CRUD on USER
public class UserDAO {
	
	public boolean isLogin(UserDTO userDTO) throws SQLException, ClassNotFoundException, NoSuchAlgorithmException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		final String SQL = "select userid from users where userid=? and password=?";
		try {
			con = CommonDAO.createConnection();
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, userDTO.getUserid());
			String encryptedPassword = Encryption.passwordEncrypt(new String(userDTO.getPassword()));
			pstmt.setString(2,encryptedPassword);
			rs = pstmt.executeQuery();
			return rs.next();
//			if(rs.next()) {
//				return true;
//			}
//			else {
//				return false;
//			}
		} 
		finally {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();
			}
			if(con!=null) {
				con.close();
			}
		}
		
	}
	
	
	public int add(UserDTO userDTO) throws ClassNotFoundException, SQLException, NoSuchAlgorithmException{
		System.out.println("Rec: " + userDTO.getUserid() + " Password: " + userDTO.getPassword());
		// To make connection
		Connection connection = null;
		
		// To do Query using this
		Statement stmt = null;
		
		try { // Guarded Region - here exception can come
			// Establish connection
			connection = CommonDAO.createConnection();
		
			// Now we will able do Query
			stmt = connection.createStatement();
			int record = stmt.executeUpdate("insert into users (userid, password) values('" +userDTO.getUserid()+"','"+Encryption.passwordEncrypt(new String((userDTO.getPassword())))+"')"); // to do insert , delete , update query
			return record;
		}
		finally { // Always execute - only will not run if encountered System.exit() first
			if(stmt!=null) {
				stmt.close();				
			}
			if(connection!=null) {
				connection.close();				
			}
		}
	}
}
