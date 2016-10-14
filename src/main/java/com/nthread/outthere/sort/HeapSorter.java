package com.nthread.outthere.sort;

import java.util.Arrays;

/**
 * Created by stephenbrown on 8/24/15.
 */
public class HeapSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        heapify(arr);
        for ( int i = arr.length-1; i > 0; i-- ) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            siftDown(arr, 0, i);
        }
    }

    public void heapify(int[] arr) {
        for(int pos = (arr.length-2)/2;pos >= 0; pos--) {
            siftDown(arr, pos, arr.length);
        }
    }

    private void siftDown(int[] arr, int pos, int end) {
        int leftPos = pos*2+1;
        int rightPos = pos*2+2;
        int leftVal = leftPos < end ? arr[leftPos] : 0;
        int rightVal = rightPos < end ? arr[rightPos] : 0;

        if ( arr[pos] > leftVal && arr[pos] > rightVal ) {
            return;
        }
        else if ( leftVal > rightVal ) {
            arr[leftPos] = arr[pos];
            arr[pos] = leftVal;
            siftDown(arr, leftPos, end);
        }
        else {
            arr[rightPos] = arr[pos];
            arr[pos] = rightVal;
            siftDown(arr, rightPos, end);
        }
    }
}
