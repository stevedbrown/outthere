package com.nthread.outthere.sort;

import org.junit.Test;

import java.util.Arrays;

import static com.nthread.outthere.sort.SortTestUtils.assertSorted;

/**
 * Created by stephenbrown on 8/24/15.
 */
public class InsertionSorterTest {

    @Test
    public void testInsertionSort() {
        int[] arr = SortData.getShuffledArray(100);
        Sorter insertionSorter = new InsertionSorter();
        System.out.println("raw:       " + Arrays.toString(arr));
        insertionSorter.sort(arr);
        System.out.println("sorted:    " + Arrays.toString(arr));
        assertSorted(arr);
    }
}
