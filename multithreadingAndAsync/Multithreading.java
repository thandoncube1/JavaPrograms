


public class Multithreading {
  public static void main(String[] args) {
    
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
