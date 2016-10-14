package com.nthread.outthere.sort;

import org.junit.Test;

import java.util.Arrays;

import static com.nthread.outthere.sort.SortTestUtils.assertSorted;

/**
 * Created by stephenbrown on 8/24/15.
 */
public class BubbleSorterTest {

    @Test
    public void testBubbleSort() {
        int[] arr = SortData.getShuffledArray(100);
        Sorter bubbleSorter = new BubbleSorter();
        System.out.println("raw:       " + Arrays.toString(arr));
        bubbleSorter.sort(arr);
        System.out.println("sorted:    " + Arrays.toString(arr));
        assertSorted(arr);
    }
}
