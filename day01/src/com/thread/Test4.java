package com.thread;

class Tt extends Thread {

	String name;
	
	public Tt() {}
	
	public Tt(String name) {
		this.name = name;
	}
	@Override
	public void run() { //source -> override -> run
		while(true) {
			System.out.println("Connected ...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Test4 {

	public static void main(String[] args) throws InterruptedException { // ���� �� ���� �������� ������ �����ϴ����� OS�� ����
		Tt tt = new Tt("T1");
		tt.setDaemon(true); // Daemon Thread : main�� ������ �˾Ƽ� ���� ����
		tt.start();
		tt.stop();
		Thread.sleep(10000);
		System.out.println("End Application");
	}

}