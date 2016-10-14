package com.nthread.outthere.sort;

import org.junit.Test;

import java.util.Arrays;

import static com.nthread.outthere.sort.SortTestUtils.assertSorted;

/**
 * Created by stephenbrown on 8/24/15.
 */
public class QuickSorterTest {

    @Test
    public void testQuickSort() {
        int[] arr = SortData.getShuffledArray(100);
        Sorter quickSorter = new QuickSorter();
        System.out.println("raw:       " + Arrays.toString(arr));
        quickSorter.sort(arr);
        System.out.println("sorted:    " + Arrays.toString(arr));
        assertSorted(arr);
    }
}
