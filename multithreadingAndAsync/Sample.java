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

  public static void main(String[] args) {
    fetchAsync("Sample.java")
      .thenApply(text -> text.length())
      .thenAccept(System.out::println)
      .join();
  }
}

