package com.nthread.outthere.sort;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by stephenbrown on 8/24/15.
 */
public class SortTestUtils {
    public static void assertSorted(int[] arr) {
        for ( int i = 0; i < arr.length-1; i++ ) {
            assert(arr[i] < arr[i+1]);
        }
    }

    public static void assertHeapified(int[] arr) {
        assertHeapifiedHelper(arr, 0);
    }

    private static void assertHeapifiedHelper(int[] arr, int pos) {
        int leftPos = pos*2+1, rightPos = pos*2+2;

        if (leftPos < arr.length) {
            assertTrue("assertHeapified:Checking:1[" + pos + "," + leftPos + "," + arr.length + "] " + arr[pos] + " > " + arr[leftPos], arr[pos] > arr[leftPos]);
            assertHeapifiedHelper(arr, leftPos);
        }
        if (rightPos < arr.length) {
            assertTrue("assertHeapified:Checking:2[" + pos + "," + rightPos + "," + arr.length + "] " + arr[pos] + " > " + arr[rightPos], arr[pos] > arr[rightPos]);
            assertHeapifiedHelper(arr, rightPos);
        }

    }
}
