import java.io.*;
import java.util.*;

/**
 * Java solution for {@link https://www.hackerrank.com/challenges/30-interfaces/problem} Day 19:
 * Interfaces
 *
 * @author Emelie Widegren <widegren.emelie@gmail.com>
 */
interface AdvancedArithmetic {
  int divisorSum(int n);
}

class Calculator implements AdvancedArithmetic {
  public int divisorSum(int n) {
    int result = 0;
    for (int i = 1; i <= n; i++) {
      if (n % i == 0) {
        result += i;
      }
    }
    return result;
  }
}

class Day19 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    scan.close();

    AdvancedArithmetic myCalculator = new Calculator();
    int sum = myCalculator.divisorSum(n);
    System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName());
    System.out.println(sum);
  }
}
