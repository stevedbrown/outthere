package com.nthread.outthere.cracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.TreeMap;

public class Shifts {

	public static void main(String[] args) {
		int x = Integer.MAX_VALUE;
		System.out.printf("x+1=%d\n", (x+1));
		System.out.printf("x+1=%d\n", (x<<1));
		System.out.printf("x+1=%d\n", (~x));
		LinkedHashMap map = new LinkedHashMap();
		HashMap map2 = new HashMap();
		TreeMap map3 = new TreeMap();
		Thread t = new Thread();
		ArrayList l = new ArrayList();
		
	}
	
	@Override
	public int hashCode(){
	    return Objects.hashCode(System.currentTimeMillis() + "");
	}

}
