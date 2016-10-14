package com.nthread.outthere.sort;

import java.util.Arrays;

/**
 * Created by stephenbrown on 8/25/15.
 */
public class QuickSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        quicksort(arr, 0, arr.length);
    }

    private void quicksort(int[] arr, int start, int end) {
        if ((end-start)<2) {
            return;
        }
        int p = partition(arr, start, end);
        quicksort(arr, start, p);
        quicksort(arr, p, end);
    }

    private int partition(int[] arr, int start, int end) {
        int p = start, val = arr[end-1];
        for ( int i = start; i < end-1; i++ ) {
            if ( arr[i] < val ) {
                swap(arr, i, p);
                p++;
            }
        }
        swap(arr, p, end - 1);
        return p;
    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
