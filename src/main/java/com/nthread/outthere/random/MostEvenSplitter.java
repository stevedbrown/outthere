package com.nthread.outthere.random;

import static com.nthread.outthere.sort.SortUtils.swap;

/**
 * Created by stephenbrown on 8/26/15.
 */
public class MostEvenSplitter {
    public int[][] split(int[] arr) {
        int[] left = new int[arr.length/2];
        int[] right = new int[arr.length-arr.length/2];
        System.arraycopy(arr, 0, left, 0, arr.length/2);
        System.arraycopy(arr, arr.length / 2, right, 0, right.length);

        boolean foundSwitch = true;
        while(foundSwitch) {
            foundSwitch = false;
            int diff = arrayDiff(left, right);

            for ( int i = 0; i < left.length; i++ ) {
                for ( int j = 0; j < right.length; j++ ) {
                    System.out.println("checking:[" + left[i] + "," + right[j] + "]:" +  (diff-2*(left[i]-right[j])) + " < " +  Math.abs(diff));
                    if ( Math.abs(diff-(2*(left[i]-right[j]))) < Math.abs(diff)) {
                        System.out.println("switching:[" + left[i] + "," + right[j] + "]:" +  (diff-2*(left[i]-right[j])) + " < " +  Math.abs(diff));
                        swap(left, i, right, j);
                        diff = arrayDiff(left, right);
                        foundSwitch = true;
                    }
                }
            }
            System.out.println(foundSwitch + ":arrdiff:" + diff);
        }
        return new int[][]{left,right};
    }

    public static int arrayDiff(int[] left, int[] right) {
        return arraySum(left) - arraySum(right);
    }

    private static int arraySum(int[] right) {
        int val = 0;
        for (int x : right) {
            val += x;
        }
        return val;
    }
}
