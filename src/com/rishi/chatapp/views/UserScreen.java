package com.rishi.chatapp.views;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class UserScreen extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		UserScreen window = new UserScreen();
		
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		// JFrame Properties
		setTitle("Login");
		setResizable(false);
		setBounds(100, 100, 578, 362);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		// Top Heading Label
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 30));
		lblNewLabel.setBounds(256, 25, 90, 38);
		getContentPane().add(lblNewLabel);
		
		// Textfield for Username
		textField = new JTextField();
		textField.setBounds(127, 90, 322, 31);
		getContentPane().add(textField);
		textField.setColumns(10);
		
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
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		registerbt.setBounds(299, 233, 98, 23);
		getContentPane().add(registerbt);
		setVisible(true);
	}
}
