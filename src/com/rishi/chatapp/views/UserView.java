package com.rishi.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	int counter;
	public UserView() {
		counter = 0;

		// JFrame Properties
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("Login");
//		setLocation(500,150);
		
		// label
		JLabel welcome = new JLabel("Login");
		welcome.setFont(new Font("Arial",Font.BOLD,40));
		welcome.setBounds(100,70,200,60);
		
		// Button
		JButton button1 = new JButton("Count"); // source where an event occur
		button1.setBounds(100,300,100,60); 
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event){ // Thing to be performed when button is clicked
				counter++;
				welcome.setText("Count: " + counter);
			}
		});

		// Container (ContentPane)
		Container container = this.getContentPane();
		container.setLayout(null);

		//Add Components
		container.add(welcome);
		container.add(button1);

		setVisible(true);
	}
	
	public static void main(String[] args) {
		UserView userView = new UserView();
	}
}
