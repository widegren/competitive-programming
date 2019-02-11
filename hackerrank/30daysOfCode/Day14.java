import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Java solution for {@link https://www.hackerrank.com/challenges/30-scope/problem} Day 14: Scope
 *
 * @author Emelie Widegren <widegren.emelie@gmail.com>
 */
class Difference {
  private int[] elements;
  public int maximumDifference;

  public Difference(int[] elements) {
    this.elements = elements;
  }

  public void computeDifference() {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int i : this.elements) {
      if (i < min) {
        min = i;
      }
      if (i > max) {
        max = i;
      }
    }
    maximumDifference = max - min;
  }
}

public class Day14 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    sc.close();

    Difference difference = new Difference(a);

    difference.computeDifference();

    System.out.print(difference.maximumDifference);
  }
}
