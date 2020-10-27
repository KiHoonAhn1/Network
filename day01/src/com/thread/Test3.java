package com.thread;

import java.util.Scanner;

class Thread1 implements Runnable {
//extends Thread {
	
	boolean flag = true;

	public Thread1() {}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	@Override
	public void run() { //source -> override -> run
		System.out.println("Start");
		while(true) { // while(true): ���ѷ��� 
			if(flag == false) {
				System.out.println("Stop ...");
				break;
			}
//			System.out.println("Connecting ...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End"); //������ ���ѷ����� ������ ������� �� ���� ������ ������ ����
		
	}
}
public class Test3 {

	public static void main(String[] args) throws InterruptedException { // ���� �� ���� �������� ������ �����ϴ����� OS�� ����
		
		// Thread ���
//		Thread1 t1 = new Thread1();
//		t1.start();
//		Thread.sleep(10000);
//		t1.setFlag(false);
		
//		Thread1 t1 = new Thread1();
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			System.out.println("Input Cmd");
//			String cmd = sc.nextLine();
//			if(cmd.equals("start")) {
//				t1 = new Thread1(); // ���� �������� ���߰� �ٽ� ������ �����ϴ�
//				t1.start();
//			}else if(cmd.equals("stop")) {
//				t1.setFlag(false);
//			}else {
//				break;
//			}
//		}
//		sc.close();
//		System.out.println("Exit Application ...");
		
		
		// Runnable 
		Thread1 r = new Thread1();
		Thread t1 = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Input Cmd");
			String cmd = sc.nextLine();
			if(cmd.equals("start")) {
				t1 = new Thread(r); // ���� �������� ���߰� �ٽ� ������ �����ϴ�
				t1.start();
			}else if(cmd.equals("stop")) {
				r.setFlag(false);
			}else {
				break;
			}
		}
		sc.close();
		System.out.println("Exit Application ...");
		
	}

}