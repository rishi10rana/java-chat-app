package com.rishi.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import com.rishi.chatapp.utils.ConfigReader;

public class Client {
	Socket socket;
	OutputStream out;
	InputStream in;
	ClientWorker clientWorker;
	JTextArea textArea;
	
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		socket = new Socket(ConfigReader.getValue("SERVER_IP"), PORT);
		
		out = socket.getOutputStream();
		in = socket.getInputStream();
		this.textArea = textArea;
		readMessages();
		
		/*Testing Code*/
//		System.out.println("Client Comes");
//		System.out.println("Enter the message send to the Server ...");
//		Scanner s = new Scanner(System.in); // buffer to store input data
//		String message = s.nextLine(); // msg i/p with space
//		OutputStream out = socket.getOutputStream(); // to send,write bytes on network
//		out.write(message.getBytes());
//		out.close();
//		s.close();
//		socket.close();
	}
	
	public void sendMessage(String message) throws IOException {
		System.out.println("Message Send : " + message);
		message = message + "\n";
		out.write(message.getBytes());
	}
	
	public void readMessages() {
		// Calling a Thread which will Read Messages
		clientWorker = new ClientWorker(in, textArea);
		clientWorker.start();
	}
	
}
