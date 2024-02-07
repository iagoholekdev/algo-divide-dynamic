package org.example.libs;

import java.util.Arrays;
import java.util.Random;

public class JavaStreamMinimumSearch {

    public static void main(String[] args) {
        int[] array = new int[24];
        for (int i = 0; i < array.length; i++) {
            int rand = new Random().nextInt(10);
            array[i] = rand;
        }
        int min = Arrays.stream(array).min().orElse(-1);
        System.out.println("array: " + Arrays.toString(array));
        System.out.println("min: " + min);
    }

}
