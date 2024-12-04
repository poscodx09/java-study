package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

import chat.ChatClientThread;

public class ChatWindow {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 9999;

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	
	private String nickname;
	private Socket socket;
	private PrintWriter writer;
	private BufferedReader reader;

	public ChatWindow(String name) {
		this.nickname = name;
		frame = new Frame(name);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
	
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent actionEvent ) {
				System.out.println("clicked");
				sendMessage();
			}
		});
		
//		buttonSend.addActionListener(actionEvent -> {});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyChar = e.getKeyChar();
				if (keyChar == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
				System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();
		

        try {
            // 1. 소켓 연결
            socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

            // 2. 스트림 설정
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            // 3. JOIN 프로토콜 전송
            writer.println("join:" + nickname);

            // 4. ChatClientThread 시작
            new ChatClientThread().start();

        } catch (IOException e) {
            System.out.println("서버 연결 실패: " + e.getMessage());
            finish();
        }
		
	}
	
	private void sendMessage() {
		String message = textField.getText();
		if (message.isEmpty()) {
	            return;
	    }

	    writer.println("message:" + message); // 서버로 메시지 전송
	        
		textField.setText("");
		textField.requestFocus();
	}
	
	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}
	
	private void finish() {
		// quit protocol 구현
		// exit java application
		try {
            if (writer != null) {
                writer.println("quit:" + nickname + "님이 퇴장했습니다.");
                writer.flush();
            }
            
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            System.out.println("소켓 종료 중 오류: " + e.getMessage());
        } finally {
            System.exit(0);
        }
		System.exit(0);
	}
	
	private class ChatClientThread extends Thread{
        @Override
        public void run() {
            try {
                String msg;
                while ((msg = reader.readLine()) != null) {
                    updateTextArea(msg); // 서버로부터 받은 메시지 출력
                }
            } catch (IOException e) {
                System.out.println("서버와의 연결 종료: " + e.getMessage());
                finish();
            }
        }
	}

}
