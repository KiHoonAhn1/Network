package com.tcpip;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port;
	ServerSocket serverSocket;
	Socket socket;
	
	public Server() {
		
	}
	public Server(int port) {
		this.port = port;
	}
	
	class Receiver extends Thread{
		DataInputStream dis;
		
		public Receiver(Socket socket) { // ��� try/catch�ϰ� ��� throw�� ������ �� �����ϱ�
			try {
				dis = new DataInputStream(socket.getInputStream()); // client�� �ϳ� ���� ������ pipe�� ����
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while(dis != null) {
				String msg = "";
				try {
					msg = dis.readUTF(); // �ѱ۵� ��Ȱ�ϰ� ���� �� �ִ�
					if(msg.equals("q")) {
						System.out.println("�ƹ����� �������ϴ�.");
						break;
					}
					System.out.println(msg);
				} catch (IOException e) {
//					e.printStackTrace();
					System.out.println("�ƹ����� �������ϴ�."); // ���������Ҷ� Exception �޽��� ���ֱ� ����
					break; // ������ ���µ� while loop�� ���ư� ������ ����
				} 
			}
			if(dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public void startServer() throws Exception {
		try{
			serverSocket = new ServerSocket(port);
			while(true) {
				System.out.println("TCP/IP Server Start");
				socket = serverSocket.accept();
				System.out.println("Connected...");
				new Receiver(socket).start(); // 100���� ������ 100���� ���������
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		Server server = new Server(7777);
		try {
			server.startServer();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
