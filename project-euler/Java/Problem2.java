import java.util.ArrayList;

/**
 * Java solution for Project Euler Problem 2: Even Fibonacci numbers
 *
 * @author Emelie Widegren <widegren.emelie@gmail.com>
 */
public class Problem2 {

  public static void main(String arg[]) {
    evenFibonacci();
  }

  /** Returns the sum of the even-valued terms below four million. */
  private static void evenFibonacci() {
    ArrayList<Integer> list = new ArrayList<Integer>();
    int result = 0, i = 0, fib = 1;

    while (fib < 4000000) {
      list.add(fib);
      if (i != 0) {
        fib = fib + list.get(i - 1);
        if (fib % 2 == 0) {
          result = result + fib;
        }
      }
      i++;
    }
    System.out.println(result);
  }
}
