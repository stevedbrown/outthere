package com.nthread.outthere.codercareer;

/**
 * Problem: Integers in an array are unique and increasingly sorted. Please write a function/method to find an 
 * integer from the array who equals to its index. For example, in the array {-3, -1, 1, 3, 5}, the number 3 
 * equals its index 3.
 * 
 * @author stephenbrown
 *
 */
public class Problem57 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int findIndex(int[] nums) {
		int start = 0, end = nums.length, mid;
		
		while( start <= end) {
			mid = mid = (start + end) / 2;
			if ( nums[mid] == mid ) {
				return mid;
			}
			else if ( nums[mid] > mid ) {
				end = mid - 1;
			}
			else 
				start = mid + 1;
		}
		
		return -1;
	}
}
