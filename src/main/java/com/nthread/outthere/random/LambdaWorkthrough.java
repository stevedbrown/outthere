package com.nthread.outthere.random;

import java.util.ArrayList;
import java.util.List;

public class LambdaWorkthrough {

	public static void printXs(List<X> xs, CheckX tester) {
		for (X x : xs) {
			if (tester.test(x)) {
				x.printX();
			}
		}
	}
	
	public static class X {

		String val;
		
		public X(String val) {
			this.val = val;
		}
		public void printX() {
			System.out.println("val is " + val);
		}
		
	}
	
	interface CheckX {
	    boolean test(X x);
	}

	public static void main(String[] args) {
		List<X> xs = new ArrayList<X>();
		xs.add(new X("one"));
		xs.add(new X("two"));
		xs.add(new X("three"));
		xs.add(new X("four"));
		
		//printXs(xs, x -> x.val.startsWith("t"));
	}
}
