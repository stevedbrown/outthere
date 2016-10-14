package com.nthread.outthere.sort;

import org.junit.Test;

import java.util.Arrays;

import static com.nthread.outthere.sort.SortTestUtils.assertHeapified;
import static com.nthread.outthere.sort.SortTestUtils.assertSorted;

/**
 * Created by stephenbrown on 8/24/15.
 */
public class HeapSorterTest {

    @Test
    public void testHeapSort() {
        int[] arr = SortData.getShuffledArray(100);
        HeapSorter heapSorter = new HeapSorter();
        System.out.println("raw:       " + Arrays.toString(arr));
        heapSorter.heapify(arr);
        System.out.println("heapified: " + Arrays.toString(arr));
        assertHeapified(arr);
        heapSorter.sort(arr);
        System.out.println("sorted:    " + Arrays.toString(arr));
        assertSorted(arr);

    }
}
