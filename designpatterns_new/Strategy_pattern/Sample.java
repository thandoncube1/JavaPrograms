package Designpatterns_new.Strategy_pattern;

import java.util.*;
import java.util.function.*;

public class Sample {
    public static int totalValues(List<Integer> values, Predicate<Integer> selector) {
        // More functional programming that imperative Java
        return values
            .stream()
            .filter(selector)
            .mapToInt(e -> e)
            .sum();
    }

    public static void main(String[] args) {
        var values = List.of(11, 23, 32, 23, 24, 15, 21);

        System.out.println(totalValues(values, e -> true));
        System.out.println(totalValues(values, Sample::isEven));
        System.out.println(totalValues(values, Sample::isOdd));
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }
}

// Refactor before you add a feature or after you add a feature
// But never in the middle of it

// Programming is 10% skill and 90% discipline

// Commit often and commit in small portions. Merge hell is what you give and should never recieve it.

// Frequent commits make the cost of undo near zero.

// ========================================================
// Strategy pattern
// We have an algorithm and we want to vary a small part of it

// Java started out with an Object Oriented idiology
// Java 1.1 we had anonymous inner classes

// You would create an interface for a Strategy
// We create a bunch of classes or anonymous inner classes
// to implement that interface.

// Step back: What is really Strategy?
// It is definitely not a class. When we are hung up on the syntax some times.

// Fundamentally, a strategy is a function.

// Naturally strategies can be implemented using lambdas