package com.sync;

public class Bank {

	public static void main(String[] args) {
		Account acc = new Account(3000);
		Wth wt = new Wth(acc);
		Dth dt = new Dth(acc);
		wt.start();
		dt.start();
		System.out.println(acc);
	}

}
