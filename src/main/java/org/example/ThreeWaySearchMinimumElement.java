package org.example;

import java.util.Arrays;
import java.util.Random;

public class ThreeWaySearchMinimumElement {

    public static int findMinimumThreeWaySearch(int[] list) {
        if (list.length == 0) return 0;
        return findMinimum(0, list.length-1, list);
    }

    public static int findMinimum(int left, int right, int[] list) {
        if (left >= right) return list[left];
        int oneThird  = left + (right - left) / 3;
        int twoThirds = left + 2 * (right - left) / 3;

        int min1 = findMinimum(left, oneThird, list);
        int min2 = findMinimum(oneThird + 1, twoThirds, list);
        int min3 = findMinimum(twoThirds + 1, right, list);

        return Math.min(Math.min(min1, min2), min3);
    }

    public static void main(String[] args) {
        int[] array = new int[24];
        for (int i = 0; i < array.length ; i++) {
            int rand = new Random().nextInt(24);
            array[i] = rand;
        }
        int min = findMinimumThreeWaySearch(array);
        System.out.println("array: " + Arrays.toString(array));
        System.out.println("max: " + min);
    }

}
