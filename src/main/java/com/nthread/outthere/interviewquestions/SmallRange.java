package com.nthread.outthere.interviewquestions;

import java.util.Arrays;

/*
 * You have k lists of sorted integers. Find the smallest range that includes 
 * at least one number from each of the k lists. 
 * For example, 
 * List 1: [4, 10, 15, 24, 26] 
 * List 2: [0, 9, 12, 20] 
 * List 3: [5, 18, 22, 30] 
 * The smallest range here would be [20, 24] as it contains 24 from list 1, 20 from
 * list 2, and 22 from list 3.
 * 
 * 0b,4a,5c,9b,10a,12b,15a,18c,20b,22c,24a,26a,30c
 */
public class SmallRange {

	public static void main(String[] args) {
		 int[][] lists = new int[][]{
				 {4, 10, 15, 24, 26},
				 {0, 9, 12, 20},
				 {5, 18, 22, 30}};
		 int minlen = Integer.MAX_VALUE, start = 0, end = 0;
		 int[] pos = new int[lists.length];
		 for (int i = 0; i < pos.length; i++ ) pos[i] = 0;
		 int count = 0;
		 while(true) {
			 int minstart = Integer.MAX_VALUE, minlist = 0;;
			 for (int i = 0; i < pos.length; i++ ) {
				 if (lists[i][pos[i]] < minstart ) {
					 minlist = i;
					 minstart = lists[i][pos[i]];
				 }
			 }
			 int maxend = 0;
			 for (int i = 0; i < pos.length; i++ ) {
				 if ( i == minlist ) continue;
				 if (lists[i][pos[i]] > maxend ) {
					 maxend = lists[i][pos[i]];
				 }
			 }
			 int len = maxend-minstart;
			 System.out.println("minstart=>"+minstart + ", minlist=>" + minlist +
					 ",maxend=>"+maxend + ",len=>"+len);
			 if ( len < minlen ) {
				 minlen = len;
				 start = minstart;
				 end = maxend;
			 }
			 if ( lists[minlist].length-1 == pos[minlist] ) 
				 break;

			 pos[minlist] = pos[minlist]+1;
			 
		 }
		 System.out.println("minlen=>"+minlen + ",start=>"+start + ", end=>" + end);
	}

}
