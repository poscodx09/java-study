package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ChatServerThread extends Thread {
	private Socket socket;
	private String nickname;
	private List<Writer> listWriters;
	
	public ChatServerThread( Socket socket, List<Writer> listWriters) {
		this.socket = socket;
		this.listWriters = listWriters;
	}
	
	@Override
	public void run() {
		try {
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			String msg = null;
			while ((msg = br.readLine()) != null) {
				String[] tokens = msg.split(":");
				// join
				if ("join".equals(tokens[0])) {
					join(tokens[1], pw);
					System.out.println("현재 인원: " + listWriters.size());
				}
				// message
				else if ("message".equals(tokens[0])) {
					message(tokens[1]);
				}
				// quit
				else if ("quit".equals(tokens[0])) {
					quit(pw);
					break;
				}
				// 이 외
				else {
					ChatServer.log("에러: 알 수 없는 요청(" + tokens[0] + ")");
				}
			}
			
		} catch (SocketException e) {
			System.out.println("[ServerError]: " + e);
		} catch (IOException e) {
			System.out.println("[ServerError]: " + e);
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("[ServerError]: " + e);
			}
			listWriters.remove(this);
		}
	}

	private void quit(Writer writer) {
		removeWriter(writer);
		String data = nickname + "님이 퇴장하였습니다.";
		broadcast(data);
	}

	private void removeWriter(Writer writer) {
		listWriters.remove(writer);
	}

	private void message(String trim) {
		log(nickname + ":" + trim);
		System.out.println(nickname + ": " + trim);
		String data = nickname + ": " + trim;
		broadcast(data);
		
	}

	private void join(String nickname, Writer writer) {
		this.nickname = nickname;
		String data = nickname + "님이 참여하였습니다.";
		log(data);
		broadcast(data);
		
		addWriter(writer);
		
		((PrintWriter) writer).println("채팅방에 입장했습니다.");
		
	}
	
	private void addWriter(Writer writer) {
		synchronized(listWriters) {
			listWriters.add(writer);
		}
	}
	
	private void broadcast(String data) {
		synchronized(listWriters) {
			for(Writer writer: listWriters) {
				PrintWriter printWriter = (PrintWriter)writer;
				printWriter.println(data);
				printWriter.flush();
			}
		}
	}
	
	private void log(String message) {
		System.out.println("[Echo Server] " + message);
		System.out.println("현재 인원: " + listWriters.size());
	}
}