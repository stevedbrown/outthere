package com.nthread.outthere.sort;

/**
 * Created by stephenbrown on 8/25/15.
 */
public class MergeSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        int[] workArr = new int[arr.length];
        splitMerge(arr, workArr, 0, arr.length);
    }

    private void splitMerge(int[] arr, int[] workArr, int start, int end) {
        if ( end-start == 1 ) {
            return;
        }

        int mid = (end + start) / 2;
        splitMerge(arr, workArr, start, mid);
        splitMerge(arr, workArr, mid, end);
        merge(arr, workArr, start, mid, end);
        copy(arr, workArr, start, end);
    }

    private void copy(int[] arr, int[] workArr, int start, int end) {
        for ( int i = start; i < end; i++ ) {
            arr[i] = workArr[i];
        }
    }

    private void merge(int[] arr, int[] workArr, int start, int mid, int end) {
        int leftPos = start, rightPos = mid;
        while( leftPos < mid || rightPos < end ) {
            int leftVal = leftPos < mid ? arr[leftPos] : Integer.MAX_VALUE;
            int rightVal = rightPos < end ? arr[rightPos] : Integer.MAX_VALUE;
            if (leftVal < rightVal) {
                workArr[start++] = leftVal;
                leftPos++;
            } else {
                workArr[start++] = rightVal;
                rightPos++;
            }
        }
    }
}
