package com.nthread.outthere.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by stephenbrown on 8/24/15.
 */
public class SortData {

    public static int[] getShuffledArray(int length) {
        return getShuffledArray(length, false);
    }

    public static int[] getShuffledArray(int length, boolean random) {
        int[] arr = getArray(length, random);
        shuffleArray(arr);
        return arr;
    }

    public static int[] getArray(int length, boolean random) {
        int[] arr = new int[length];
        for ( int i = 0; i < length; i++ ) {
            arr[i] = random ? Math.round((float)(Math.random() * 100000)) : (i + 1);
        }
        return arr;
    }

    // Implementing Fisher–Yates shuffle
    static void shuffleArray(int[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void main(String[] args) {
        int[] arr = getShuffledArray(100);
        System.out.println(Arrays.toString(arr));
    }
}
