package Designpatterns_new.Factory_method;

interface Player {
    Pet getPet(); // Factory method on the Interface

    default void play() {
        System.out.println("I like playing...");
        System.out.println("playing with " + getPet());
    }
}

interface  Pet{}
class Dog implements Pet {}
class Cat implements Pet {}

class DogLover implements Player {
    public Pet getPet() { return new Dog(); }
}

public class Sample {
    public static void callPlayer(Player player) {
        player.play();
    }
    public static void main(String[] args) {
        callPlayer(new DogLover());
    }
}

/*
 * "Factory" - an abstraction to create an object
 *  "Method" - Inheritance heirarchy where we can override a method to provide an alternative implementation that we return
 *
 * Typically we have a base class (abstract) and derived classes
 * that override the "factory" method
 *
 * In general interfaces are better than abstract base class.
 */