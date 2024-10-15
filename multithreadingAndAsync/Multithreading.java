import java.util.*;

public class Multithreading {
  public static void main(String[] args) {
    var names = List.of("Dory", "Gill", "Bruce", "Nemo", "Darla", "Marlin", "Jacques");

    names.stream()
      .parallel() // Parallel, is optional for this block, only when you need it.
      .filter(name -> name.length() == 4)
      .map(String::toUpperCase)
      .forEach(System.out::println);
  }
}

// Pool induced deadlock
// - Solving one solution to a problem only to realize
// We have created more problems
//
// # Executor Services
// # ForkJoinPool
//
// - In the past the structure of imperative code is very different from the
// structure of imperative style sequential code.
//
// - Starting in Java 8, the structure of functional style parallel code is the
//  same as the structure of functional style sequential code. -- Thanks to Streams
//
// T T T T       Talk
// W W W W       Walk
// --------------------------------------
// T D T D T D T D                Talk Drink
// -------------------------------------
//
// Asynchronous
//
// Non-blocking calls
//
// - If you ask for data, you have to wait for the result
// - All tasks are always blocking unless they do not care for the data
// - When a task blocks, the threads (SADLY) blocks with it.
// - When we say blocking vs. non-blocking we are talking about the thread of execution.
//
// How many threads can you create on a Machine?
//  - Depends on the number of cores
//  - The number of processors per core
//  - THat will determine the number of threads per process.
//
//  A good "waiter" should never wait.
//
// When a task blocks we do not want the underlying thread to block
// - A non-block is about the thread of execution - It directly impacts your
//  scalability.
// - If the thread is waiting it affects your architectural process.
// - If you force in to an architecture what is not important to the business
//  you fail big. If you provide what is not needed, it prevents you from providing
//  what is needed. Programming Asynchronous can be difficult, therefore you should only 
//  program asynchronously only when the business case needs it.
