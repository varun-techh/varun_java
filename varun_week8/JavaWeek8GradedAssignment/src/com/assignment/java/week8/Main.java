package com.assignment.java.week8;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(numbers)
                .filter(n -> n % 2 != 0) // Filter out odd numbers
                .map(n -> n * n) // Square the numbers
                .reduce(0, Integer::sum); // Find the sum

        System.out.println("ODD NUMBERS : " + Arrays.toString(numbers));
        System.out.println("SQUARES : " + Arrays.toString(numbers));
        System.out.println("SUM : " + sum);
        System.out.println("OUTPUT : " + sum);
    }
}
