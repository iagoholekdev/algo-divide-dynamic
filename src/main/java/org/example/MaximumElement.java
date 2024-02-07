package org.example;

import java.util.Arrays;
import java.util.Random;

public class MaximumElement {

    public static Integer findMaximumElement(int[] list) {
        if (list.length == 0) return null;
        return findMax(0, list.length-1, list);
    }

    public static int findMax(int leftArr, int rightArr, int[] list) {
            if (leftArr >= rightArr) return list[leftArr];
            int mid = (leftArr + rightArr) / 2;
            return Math.max(findMax(leftArr, mid, list),
                    findMax(mid+1, rightArr, list));
    }

    public static void main(String[] args) {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            int rand = new Random().nextInt(10);
            array[i] = rand;
        }
        Integer max = findMaximumElement(array);
        System.out.println("array: " + Arrays.toString(array));
        System.out.println("max: " + max);
    }

}
