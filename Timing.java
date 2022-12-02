import java.util.Random;

public class Timing {
  public static void main(String[] args) {
    Random rand = new Random();
    int SIZE = 1024;
    int[] arr = new int[SIZE];

    // generate random numbers for array
    for (int i = 0; i < SIZE; i++) {
      arr[i] = rand.nextInt();
    }
  }
}