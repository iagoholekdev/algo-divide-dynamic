package org.example;

import java.util.Arrays;
import java.util.Random;

public class MinimumElement {
    public static Integer findMinimumElement(int[] list) {
        if (list.length == 0) return null;
        return findMin(0, list.length-1, list);
    }

    public static int findMin(int leftArr, int rightArr, int[] list) {
        if (leftArr >= rightArr) return list[leftArr];
        int mid = (leftArr + rightArr) / 2;
        return Math.min(findMin(leftArr, mid, list),
                findMin(mid+1, rightArr, list));
    }

    public static void main(String[] args) {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            int rand = new Random().nextInt(10);
            array[i] = rand;
        }
        Integer min = findMinimumElement(array);
        System.out.println("array: " + Arrays.toString(array));
        System.out.println("max: " + min);
    }

}
