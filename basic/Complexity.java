public class Complexity {
  public static void main(String[] args) {
    // Run a for loop to check time compexity
    int[] myArray = new int[5];
    myArray[0] = 1;
    myArray[1] = 4;
    myArray[2] = 2;
    myArray[3] = 23;
    myArray[4] = 12;

    for (int i = 0; i < myArray.length; i++) {
      for (int j = i; j < myArray.length; j++) {
          System.out.println(myArray[i] * myArray[j]);
      }
    }
  }
}
