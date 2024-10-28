package Designpatterns_new.collections;

import java.util.Arrays;

public class Sample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 6, 7, 9};

        System.out.println(tranformNumbers(numbers));
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int tranformNumbers(int[] numbers) {
        return Arrays
        .stream(numbers)
        .filter(Sample::isEven)
        .sum();
    }
}
