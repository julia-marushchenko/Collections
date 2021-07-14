package com.BinarySearch;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int n = 1000; // number of all elements
        final int nKey = 500; // number of filled elements
        final double key = 0.5; // a step of filling
        double[] arr = new Random().doubles().limit(n).toArray();
        Arrays.fill(arr, 0, nKey, key);
        Arrays.sort(arr);
        int count = countBinarySearch(arr, key);
        assert count == nKey;
        System.out.println(count);
    }

    /**
     * return index ix such that arr[ix-1] < key, for any i >= ix arr[i] >= key
     *
     * @param arr
     * @param key
     * @return index ix such that arr[ix-1] < key, for any i >= ix arr[i] >= key
     */
    public static int leftBinarySearch(double[] arr, double key) {
        int ix = -1;
        return ix;
    }

    /**
     * return index ix such that arr[ix+1] > key, for any i <= ix arr[i] <= key
     *
     * @param arr
     * @param key
     * @return index ix such that arr[ix+1] > key, for any i <= ix arr[i] <= key
     */
    public static int rightBinarySearch(double[] arr, double key) {
        int ix = -1;
        return ix;
    }

    public static int countBinarySearch(double[] arr, double key) {
        return rightBinarySearch(arr, key) - leftBinarySearch(arr, key);
    }
}