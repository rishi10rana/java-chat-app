package com.rishi.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

// Thread == Worker
// Worker need a Job to Perform
// For Job u give Runnable (Interface)
// once job is created via Runnable so write the job  logic inside a run function
// assign the job to a Thread/Worker

 public class ServerWorker extends Thread{
	 private Socket clientSocket;
	 private InputStream in;
	 private OutputStream out;
	 private Server server; // to get server information
	 
	 public  ServerWorker(Socket clientSocket,Server server) throws IOException {
		 this.server = server;
		 this.clientSocket = clientSocket;
		 in = clientSocket.getInputStream(); // read/receive client data
		 out = clientSocket.getOutputStream(); // write data to client
		 System.out.println("New Client Comes ");
	 }
	 @Override
	 public void run() {
		 // Job to Do
		 // Read Data from the Client and BroadCast the data to all
		 BufferedReader br = new BufferedReader(new InputStreamReader(in)); // bufferedreader gives data in string form line by line
		 String line;
		 try {
			 while(true) {
				 line = br.readLine();
				 System.out.println("Read Line - " + line);
				 if(line.equalsIgnoreCase("quit")) {
					 break; // Client chat end
				 }
//				 out.write(line.getBytes()); // Client Send
				 
				 // BroadCast to All Other Clients
				 for(ServerWorker serverWorkers : server.workers) {
					 serverWorkers.out.write((line+"\n").getBytes());
				 }
			 
			 } 
		 }catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		 finally {
			 try {
				 if(br!=null) {
					 br.close();
				 }
				 if(in!=null) {
					 in.close();
				 }
				 if(out!=null) {
					 out.close();
				 }
				 if(clientSocket!=null) {
					 clientSocket.close();
				 }
			 }
			 catch(Exception e) {
				 e.printStackTrace();
			 }
		 }
	 }
 }