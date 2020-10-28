package com.tcpip2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.msg.Msg;

// Object Serialization ...

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
//		DataInputStream dis;
		ObjectInputStream dis;
		Socket socket = null;
		
		public Receiver(Socket socket) { // 어디서 try/catch하고 어디서 throw로 던질지 잘 생각하기
			try {
				dis = new ObjectInputStream(socket.getInputStream()); // client가 하나 들어올 때마다 pipe가 생김
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			while(dis != null) {
				Msg mo = null;
				try {
					mo = (Msg) dis.readObject();
					if(mo.getMsg().equals("q")) {
						System.out.println(mo.getId()+" 님이 나갔습니다.");
//						dis.reset();
						break;
					}
					System.out.println("["+mo.getId()+"]"+mo.getMsg());
				} catch (Exception e) {
					e.printStackTrace();
//					if(mo.getId() != null) {
//					System.out.println(mo.getId()+" 님이 나갔습니다.");} // 강제종료할때 Exception 메시지 없애기 위해
					break; // 에러가 났는데 while loop가 돌아갈 이유가 없다
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
			System.out.println("TCP/IP Server Start");
			while(true) {
				socket = serverSocket.accept();
				System.out.println(socket.getInetAddress()+" Connected");
				new Receiver(socket).start(); // 100명이 들어오면 100개가 만들어진다
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
