import java.util.*;
import java.util.Scanner;

/**
 * Java solution for
 * {@link https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * Longest Substring Without Repeating Characters}
 *
 * @author Emelie Widegren <emeliewide@gmail.com>
 */
class LongestSubstring {
  public static int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<Character>();
    int result = 0;

    int left = 0;
    int right = 0;

    while (right < s.length()) {
      if (!set.contains(s.charAt(right))) {
        set.add(s.charAt(right));
        right++;
        result = Math.max(result, right - left);
      } else {
        set.remove(s.charAt(left));
        left++;
      }
    }
    return result;
  }

  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    String string = sc.next();
    System.out.println(lengthOfLongestSubstring(string));
    sc.close();
  }
}
