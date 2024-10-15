import java.util.concurrent.*;
import java.nio.file.*;

public class Sample {
  public static String fetch(int index, String path) {
    try {
      System.out.println(index + "enter" + Thread.currentThread());

      var result = Files.readString(Path.of(path));

      System.out.println(index + "after" + Thread.currentThread());

      return result;
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }
  public static void main(String[] args) {
    // We don't use the cloud on small business use cases
    // for availablity
    var MAX = 5;

    for (int i = 0; i < MAX; i++) {
      int index = i;
      // new Thread(() -> fetch(index, "main.txt")).start();
      Thread.startVirtualThread(() -> fetch(index, "main.txt"));
    }

    try { Thread.sleep(5000); } catch(Exception ex) {}
  }
}

// AOP - "Aspect Oriented Programming"
// There is a lot of mounting and unmounting when dealing with virtual threads
// Because you are unmounting and mounting you can have multiple threads
//
// With Java 21, the structure of imperative style asynchronous code 
