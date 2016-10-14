package com.nthread.outthere.sort;

import java.util.HashMap;

import static com.nthread.outthere.sort.SortUtils.swap;

/**
 * Created by stephenbrown on 8/25/15.
 */
public class SelectionSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++ ) {
            int pos = i;
            for( int j = i; j < arr.length; j++ ) {
                if (arr[j] < arr[pos]) {
                    pos = j;
                }
            }
            swap(arr, i, pos);
        }
    }

    HashMap m = new HashMap();




}
