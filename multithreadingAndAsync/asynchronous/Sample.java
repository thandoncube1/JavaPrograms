import java.util.concurrent.*;
import java.nio.file.*;

public class Sample {
  public static String fetch(String path) {
    try {
      return Files.readString(Path.of(path));
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  public static CompletableFuture<String> fetchAsync(String path) {
    return CompletableFuture.supplyAsync(() -> fetch(path));
  }

  public static Void handleException(Throwable throwable) {
    System.out.println("ERROR: " + throwable);
    return null;
  }

  public static void main(String[] args) {
    fetchAsync("main.txt")
      .thenApply(text -> text)
      .thenAccept(System.out::println)
      .exceptionally(err -> handleException(err))
      .join();
  }
}

/* If all is well, go to the next then...
 * If there is a failure, go the next exceptionally...
 * */

// Functional programming is awesome when your functions are pure, they do not have
// side effects.
//
// If your code has to deal with side effects or exceptions, functional programming is not
// ideal. You can't maintain it easily. The more functions and code you need to use.
//
// If your code is imperative it turns into a monster and if its sequential it is beautiful.
//
// -- Virtual Threads - are super light weight threads
//
// -- Running on the cloud can be for availability instead of scalability
// -- Especially when dealing with small businesses.
