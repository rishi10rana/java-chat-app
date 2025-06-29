package com.rishi.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


import com.rishi.chatapp.utils.ConfigReader;

public class Server {
	ServerSocket serverSocket;
	// To store object of each worker managing client/socket
	ArrayList<ServerWorker> workers = new ArrayList<>();
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server Started and Waiting for the Client ...");
		handleClientRequest();
	}
	
	// Multiple Client HandShaking
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket = serverSocket.accept(); // Handshaking with client 
			// Per Client Per Thread
			ServerWorker serverWorker = new ServerWorker(clientSocket,this); // creating a new worker/thread
			workers.add(serverWorker);
			serverWorker.start(); // to start the thread for each client that comes
		}
	}
	
	/*Single Client*/
	/*
	public Server() throws IOException {
		int PORT = Integer.parseInt(ConfigReader.getValue("PORTNO"));
		serverSocket = new ServerSocket(PORT);
		System.out.println("Server Started and waiting for the Client Connection ...");
		
		Socket socket = serverSocket.accept(); // Handshaking with client 
		System.out.println("Client joins the Server");
		
		InputStream in = socket.getInputStream(); // read bytes from network
		byte arr[] = in.readAllBytes();
		String str = new String(arr); // convert byte to string
		System.out.println("Message received from client : " + str);
		
		in.close();
		socket.close();
		serverSocket.close();
	}
	*/

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Server server = new Server();
	}

}