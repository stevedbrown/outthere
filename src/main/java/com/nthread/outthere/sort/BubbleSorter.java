package com.nthread.outthere.sort;

import java.util.Arrays;

import static com.nthread.outthere.sort.SortUtils.swap;

/**
 * Created by stephenbrown on 8/25/15.
 */
public class BubbleSorter implements Sorter {
    @Override
    public void sort(int[] arr) {
        boolean foundBubble = true;
        while(foundBubble) {
            System.out.println(Arrays.toString(arr));
            foundBubble = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    foundBubble = true;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
