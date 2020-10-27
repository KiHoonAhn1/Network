package com.thread;

class Th extends Thread {

	String name;
	
	public Th() {}
	public Th(String name) {
		this.name = name;
	}
	
	@Override
	public void run() { //source -> override -> run
		for(int i=0;i<=100;i++) {
			System.out.println(name+":"+i);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Test2 {

	public static void main(String[] args) { // ���� �� ���� �������� ������ �����ϴ����� OS�� ����
		Thread t1 = new Thread(new Th("T1"));
		t1.start();
		t1.setPriority(10);
		Thread t2 = new Thread(new Th("T2"));
		t2.start();
		t1.setPriority(1);
	}

}
