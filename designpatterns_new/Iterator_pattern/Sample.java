package Designpatterns_new.Iterator_pattern;

import java.util.*;

public class Sample {
    public static void main(String[] args) {
        var names = List.of("Tom", "Jerry", "Darla", "Bob", "Jack");

        // External iterator - Imperative style of programming
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));

            if (names.get(i).equals("Bob")) {
                break;
            }
        }

        // also an external iterator
        for (var name: names) {
            System.out.println(name);
            // Things like break, continue etc.
        }

        System.out.println("-----------");
        // Internal iterators - Functional programming
        names
        .stream()
        //.takeWhile(name -> !name.equals("Bob"))
        .limit(3)
        .forEach(System.out::println);

        // TakeWhile is the functional programming equivalent of imperative programming style break.
    }
}

// The more design patterns we talk about the less powerful a language is
// The more powerful a language is the more we will use
// integrated features than design patterns.
// In imperative style we use statements and expressions.
// In functional programming we often use expressions instead of statements. In FP we don't want to cause side effects instead of mutations.