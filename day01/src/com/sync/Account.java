package com.sync;

public class Account {
	private int balance;
	public Account() {}
	public Account(int balance) {
		this.balance = balance;
	}
	public int getBalance() {
		return balance;
	}
	
	public synchronized void deposit(int money) {
		synchronized(this) { //�ϳ��� ������ ������ �����ϰԲ� �ؼ� ���̳ʽ�(-)�� ������ ������ ������ ��, �ӵ��� ������
		if(money >= 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance += money;
		}
	}
	}
	public void withdraw(int money) {
		synchronized(this) {
		if(balance >= money) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			balance -= money;
		}
	}
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + "]";
	}
	
	
}