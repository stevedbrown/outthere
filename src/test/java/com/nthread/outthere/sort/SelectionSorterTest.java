package com.nthread.outthere.sort;

import org.junit.Test;

import java.util.Arrays;

import static com.nthread.outthere.sort.SortTestUtils.assertSorted;

/**
 * Created by stephenbrown on 8/24/15.
 */
public class SelectionSorterTest {

    @Test
    public void testSelectionSort() {
        int[] arr = SortData.getShuffledArray(100);
        Sorter selectionSorter = new SelectionSorter();
        System.out.println("raw:       " + Arrays.toString(arr));
        selectionSorter.sort(arr);
        System.out.println("sorted:    " + Arrays.toString(arr));
        assertSorted(arr);
    }
}
