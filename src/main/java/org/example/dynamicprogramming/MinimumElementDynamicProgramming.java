package org.example.dynamicprogramming;

import java.util.Arrays;

public class MinimumElementDynamicProgramming {

    public static Integer findMinimumElement(int[] list) {
        if (list.length == 0) return null;

        Integer[][] memo = new Integer[list.length][list.length];

        return findMin(0, list.length - 1, list, memo);
    }

    private static int findMin(int left, int right, int[] list, Integer[][] memo) {
        if (memo[left][right] != null) return memo[left][right];

        if (left >= right) {
            memo[left][right] = list[left];
            return list[left];
        }

        int oneThird = left + (right - left) / 3;
        int twoThirds = left + 2 * (right - left) / 3;

        int min1 = findMin(left, oneThird, list, memo);
        int min2 = findMin(oneThird + 1, twoThirds, list, memo);
        int min3 = findMin(twoThirds + 1, right, list, memo);

        memo[left][right] = Math.min(Math.min(min1, min2), min3);

        return memo[left][right];
    }

    public static void main(String[] args) {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            int rand = (int) (Math.random() * 10);
            array[i] = rand;
        }

        int min = findMinimumElement(array);
        System.out.println("array: " + Arrays.toString(array));
        System.out.println("min: " + min);

    }
}
