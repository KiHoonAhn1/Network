package com.thread;

class T extends Thread {

	String name;
	
	public T() {}
	public T(String name) {
		this.name = name;
	}
	
	@Override
	public void run() { //source -> override -> run
		for(int i=0;i<=100;i++) {
			System.out.println(name+":"+i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class Test {

	public static void main(String[] args) { // 누가 더 많은 점유율을 가지고 동작하는지는 OS가 결정
		T t1 = new T("T1");
		t1.start();
		T t2 = new T("T2");
		t2.start();
	}

}
