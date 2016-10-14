package com.nthread.outthere.sort;

import java.util.Arrays;

/**
 * Created by stephenbrown on 8/25/15.
 */
public class InsertionSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        for ( int i = 1; i < arr.length; i++ ) {
            int val = arr[i], j = i;
            while( j > 0 && val < arr[j-1] ) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = val;
            System.out.println(Arrays.toString(arr));
        }
    }
}
