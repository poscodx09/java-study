package chat;

import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final int SERVER_PORT = 9999;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		List<Writer> listWriters = new ArrayList<Writer>();
		
		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", SERVER_PORT));
			log("starts...[port:" + SERVER_PORT + "]");
			
			
			while (true) {
				Socket socket = serverSocket.accept(); // blocking
				new ChatServerThread(socket, listWriters).start();
			}
			

		} catch (IOException e) {
			log("error" + e);
		} finally {
			try {
				if (serverSocket != null && !serverSocket.isClosed())
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void log(String message) {
		System.out.println("[Echo Server] " + message);
	}
}