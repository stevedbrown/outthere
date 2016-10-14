package com.nthread.outthere.sort;

import org.junit.Test;

import java.util.Arrays;

import static com.nthread.outthere.sort.SortTestUtils.assertHeapified;
import static com.nthread.outthere.sort.SortTestUtils.assertSorted;

/**
 * Created by stephenbrown on 8/24/15.
 */
public class MergeSorterTest {

    @Test
    public void testMergeSort() {
        int[] arr = SortData.getShuffledArray(100);
        Sorter mergeSorter = new MergeSorter();
        System.out.println("raw:       " + Arrays.toString(arr));
        mergeSorter.sort(arr);
        System.out.println("sorted:    " + Arrays.toString(arr));
        assertSorted(arr);

    }
}
