package Designpatterns_new.patterns_antipattern;

import java.util.*;

public class Sample {
    private String configInfo;
    // private Optional<String> configInfo; Do not use this way, overhead with little benefit

    public static Optional<String> getName(long id) {
        if (id == 0) {
            return Optional.empty(); // null is a smell
        }

        return Optional.of("some name");
    }

    // 1. Return a reference if the value will always exist
    // 2. Return an Optional<T> if the value may or may not exist. I need to query the data before I use the code
    // 3. Do not use Optional<T> for fields
    // 4. Do not use Optional<T> for method parameters
    public static void main(String[] args) {
        var result = getName(0);

        // imperatively
        if (result.isPresent()) {
            //Please for(get) Don't use get because it blows up without warning
            // orElseThrow or use orElse("default value")
            System.out.println(result.orElseThrow());
        } else {
            System.out.println("Not found");
        }

        // Functionally
        result.ifPresentOrElse(
            name -> System.out.println(name),
            () -> System.out.println("Not found"));
    }
}


// Code should reveal its intentions - When you deal with code that reveals its
// intentions you get along with your work. But you will struggle with code that does not reveal its intentions.
// Bad - design is everywhere around us...We need to design things that are really good enough and can easily be understood