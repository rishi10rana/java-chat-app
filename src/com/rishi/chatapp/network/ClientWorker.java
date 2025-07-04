package com.rishi.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JTextArea;

// A Thread for the client to actively listen for the incoming messages
// Basically Reads Incoming Messages
public class ClientWorker extends Thread{
	private InputStream in;
	private JTextArea textArea;
	
	public ClientWorker(InputStream in,JTextArea textArea) {
		this.textArea = textArea;
		this.in = in;
	}
	
	
	@Override
	public void run() {
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String line;
		try {
			while(true) {
				line = br.readLine();
//				textArea.setText(textArea.getText() + line);
				textArea.append(line + "\n");
			}			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			if(in!=null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
