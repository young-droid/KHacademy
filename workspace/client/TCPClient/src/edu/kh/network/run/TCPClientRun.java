package edu.kh.network.run;

import edu.kh.network.model.service.TCPClient;

public class TCPClientRun {
	public static void main(String[] args) {
		System.out.println("test");
		
		TCPClient client = new TCPClient();
		
		client.clientStart();
		
	}
}
