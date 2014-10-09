package com.nthread.outthere.projecteuler;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

	public static List<Integer> primeFactors(int n) {

		List<Integer> factors = new ArrayList<Integer>();
		for (int i = 2; i <= n / i; i++) {
			if (n % i == 0) {
				int factor = 1;
				while (n % i == 0) {
					factor *= i;
					n /= i;
				}
				factors.add(factor);
			}
		}
		if (n > 1) {
			factors.add(n);
		}
		return factors;
	}

	public static void main(String[] args) {
		System.out.println("Primefactors of 643");
		for (Integer integer : primeFactors(643)) {
			System.out.println(integer);
		}

		System.out.println("Primefactors of 644");
		for (Integer integer : primeFactors(644)) {
			System.out.println(integer);
		}

		System.out.println("Primefactors of 645");
		for (Integer integer : primeFactors(645)) {
			System.out.println(integer);
		}
	
		System.out.println("Primefactors of 646");
		for (Integer integer : primeFactors(646)) {
			System.out.println(integer);
		}
	}
}
