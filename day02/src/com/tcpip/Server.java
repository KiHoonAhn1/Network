package com.tcpip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	int port = 9999;
	ServerSocket serverSocket;
	Socket socket;

	InputStreamReader ir;
	BufferedReader br;

	public Server() {

	}

	public void startServer() throws IOException {
		serverSocket = new ServerSocket(port);
		try {
			while (true) {
				System.out.println("Ready Server ...");
				socket = serverSocket.accept(); // server�� ���� ���� �ݵ�� close�� ����� �Ѵ�
				System.out.println("Connected .."); // server�� �׾�����Ƿ� while ����
				ir = new InputStreamReader(socket.getInputStream(), "UTF-8");
				br = new BufferedReader(ir);
				String msg = "";
				msg = br.readLine();
				System.out.println(msg);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (br != null) {
				br.close();
			}
			if (socket != null) {
				socket.close();
			}
		}
	}

	public static void main(String[] args) {
		Server server = null;
		server = new Server();
		try {
			server.startServer();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Server End");
	}

}
