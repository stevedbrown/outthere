package com.nthread.outthere.random;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class LambdaWorkthrough {

	public static void printXs(List<X> xs, CheckX tester) {
		for (X x : xs) {
			if (tester.test(x)) {
				x.printX();
			}
		}
	}
	
	public static class X {

		final String val;
		final public int intVal;
		
		public X(String val, int intVal) {
			this.val = val;
			this.intVal = intVal;
		}
		public void printX() {
			System.out.printf("val is %s:%d\n", val, intVal);
		}
		
	}
	
	interface CheckX {
	    boolean test(X x);
	}

	public static void main(String[] args) {
		System.out.println("...starting run");
		List<X> xs = new ArrayList<X>();
		xs.add(new X("one", 1));
		xs.add(new X("two", 2));
		xs.add(new X("three", 3));
		xs.add(new X("four", 4));

		System.out.println("...print all");
		xs.forEach(x -> x.printX());
		
		System.out.println("...print ts");
		printXs(xs, x -> x.val.startsWith("t"));
		System.out.println("...starting stream");
		System.out.printf("all match? %b", xs.stream().allMatch(t -> t.intVal % 2 == 1));
		xs.stream().filter(p -> p.intVal > 2).map(x -> x.val + x.intVal).forEach(val -> System.out.printf("...%s", val));
		System.out.println("...finished");
	}
}
