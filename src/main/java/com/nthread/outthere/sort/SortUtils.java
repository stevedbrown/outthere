package com.nthread.outthere.sort;

/**
 * Created by stephenbrown on 8/25/15.
 */
public class SortUtils {
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void swap(int[] left, int leftPos, int[] right, int rightPos) {
        int tmp = right[rightPos];
        right[rightPos] = left[leftPos];
        left[leftPos] = tmp;
    }
}
