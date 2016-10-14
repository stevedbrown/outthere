package com.nthread.outthere.cracking;

public class NumberSwap {

	public static void main(String[] args) {
		int a = 16, b = 27;
		System.out.printf("a:%d, b:%d\n", a, b);
		a = (b+(b=a))-a;

		System.out.printf("a:%d, b:%d\n", a, b);
		
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.printf("a:%d, b:%d\n", a, b);
		
		int c = 2;
		System.out.printf("c:%d\n", c);
		c <<= 2;
		System.out.printf("c:%d\n", c);
		c = ~c;
		System.out.printf("c:%d\n", c);
		System.out.println("...done");
	}
}
