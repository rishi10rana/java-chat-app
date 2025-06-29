package com.rishi.chatapp.views;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.rishi.chatapp.dao.UserDAO;
import com.rishi.chatapp.dto.UserDTO;
import com.rishi.chatapp.utils.UserInfo;

public class UserScreen extends JFrame{

	private JFrame frame;
	private JTextField useridtxt;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UserScreen window = new UserScreen();
		
	}
	
	UserDAO userDAO = new UserDAO();
	
	private void doLogin() {
		String userid = useridtxt.getText();
		char[] password = passwordField.getPassword(); // to handle password securely
		
//		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
			String message = "";
			if(userDAO.isLogin(userDTO)) {
				message = "Welcome " + userid;
				UserInfo.USER_NAME = userid;
				JOptionPane.showMessageDialog(this, message);
				setVisible(false);
				dispose(); // this closes the current window
				
				DashBoard dashBoard = new DashBoard(message);
				dashBoard.setVisible(true);
			}
			else {
				message = "Invalid UserID or Password !";
				JOptionPane.showMessageDialog(this, message);
			}
		} catch (ClassNotFoundException | NoSuchAlgorithmException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void register() {
		String userid = useridtxt.getText();
		char[] password = passwordField.getPassword(); // to handle password securely
		
//		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid, password);
		
		try {
			int result = userDAO.add(userDTO);
			if(result > 0) {
				JOptionPane.showMessageDialog(this, "User Registered Successfully :)");
//				System.out.println("Record Added Successfully...");
			}
			else {
				JOptionPane.showMessageDialog(this, "User Registeration Failed :(");
//				System.out.println("Record Not Added :(");
			}
		}
		catch(ClassNotFoundException | SQLException ex) {
			System.out.println("DB Issue ...");
			ex.printStackTrace();
		}
		catch(Exception ex) {
			System.out.println("Some Generic Exception Raised ...");
			ex.printStackTrace();
		}
		
//		System.out.print("User Id: " + userid + " Password: " + password.toString()); // ClassName@HashCode(Hexadecimal)
	}
	

	/**
	 * Create the application.
	 */
	public UserScreen() {
		// JFrame Properties
		setTitle("Login");
		setResizable(false);
		setSize(578, 362);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		// Top Heading Label
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(256, 25, 90, 38);
		getContentPane().add(lblNewLabel);
		
		// Textfield for Username
		useridtxt = new JTextField();
		useridtxt.setBounds(127, 90, 322, 31);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		// Label for Username
		JLabel useridlbl = new JLabel("User ID :");
		useridlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		useridlbl.setBounds(33, 87, 84, 31);
		getContentPane().add(useridlbl);
		
		// Label for Password
		JLabel pwdlbl = new JLabel("Password :");
		pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pwdlbl.setBounds(19, 150, 98, 31);
		getContentPane().add(pwdlbl);
		
		// PasswordField
		passwordField = new JPasswordField();
		passwordField.setBounds(127, 153, 322, 31);
		getContentPane().add(passwordField);
		
		// Login Button
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doLogin();
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		loginbt.setBounds(181, 233, 98, 23);
		getContentPane().add(loginbt);
		
		// Register Button
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerbt.setBounds(299, 233, 98, 23);
		getContentPane().add(registerbt);
		setVisible(true);
	}
}
