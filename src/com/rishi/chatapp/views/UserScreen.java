package com.rishi.chatapp.views;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.rishi.chatapp.dao.UserDAO;
import com.rishi.chatapp.dto.UserDTO;

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
	
	
	private void register() {
		String userid = useridtxt.getText();
		char[] password = passwordField.getPassword(); // to handle password securely
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid, password);
		
		int result = userDAO.add(userDTO);
		
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
