
public class Sample_Switch {
  public static String process(int input) {
    return switch(input) {
      case 1 -> "one";
      case 2, 3 -> "two or three";
      case 4 -> {
        System.out.println("called...");
        yield "four";
      }
      default -> "whatever";
    };
  }

  public static void main(String[] args) {
    System.out.println(process(1));
    System.out.println(process(2));
    System.out.println(process(3));
    System.out.println(process(4));
  }
}
