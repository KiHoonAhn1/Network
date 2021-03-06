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
		synchronized(this) { //하나가 끝나야 다음이 동작하게끔 해서 마이너스(-)가 나오는 오류가 없도록 함, 속도가 느려짐
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
