/**
 * Java solution for Project Euler Problem 1: Multiples of 3 and 5
 *
 * @author Emelie Widegren <widegren.emelie@gmail.com>
 */
public class Problem1 {

  public static void main(String arg[]) {
    System.out.println(multiples());
  }

  /** Returns the sum of all the multiples of 3 or 5 below 1000. */
  private static int multiples() {
    int result = 0;
    for (int i = 0; i < 1000; i++) {
      if (i % 3 == 0 || i % 5 == 0) {
        result += i;
      }
    }
    return result;
  }
}
