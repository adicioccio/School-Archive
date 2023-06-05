/*
 Adam Di Cioccio - 41019241
 Lab 10 - 4/14/2021
 Wenjuan Jiang
 SimpleServer - A program that creates a connection to the client using port 1254
 */

//imports
import java.net.*;
import java.io.*;

//class
public class SimpleServer {
	
	//main method
	public static void main(String[] args) {
		
		try {
			//create new server socket
			ServerSocket ss = new ServerSocket(1254);
			//establish connection
			Socket s = ss.accept();
			//print out client connected
			System.out.println("client connected.");
		
		//catch exception
		} catch (IOException e) {
			e.printStackTrace();
		//finally statement
		} finally {
			System.out.println("try catch finished.");
		}

	}
}
