import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

public class Day6 {
  public static void main(String[] args) {
    String everything = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader("input6.txt"));
      StringBuilder sb = new StringBuilder();
      String line = br.readLine();

      while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        line = br.readLine();
      }
      everything = sb.toString();
      br.close();
    } catch (IOException ex) {
      System.out.println(ex.toString());
    }
    String[] parts = everything.split("\\s+");
    String str1 = "", str2 = "";
    for (int i = 0; i < parts[0].length(); i++) {
      String tmp = "";
      for (String s : parts) {
        tmp += s.charAt(i);
      }
      str1 += part1(tmp);
      str2 += part2(tmp);
    }
    System.out.println(str1);
    System.out.println(str2);
  }

  static char part1(String str) {
    Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
    for (char c : str.toCharArray()) {
      if (hash.containsKey(c)) {
        hash.put(c, hash.get(c) + 1);
      } else {
        hash.put(c, 1);
      }
    }
    int max = 0;
    char result = '0';
    for (Entry<Character, Integer> e : hash.entrySet()) {
      if (e.getValue() > max) {
        max = e.getValue();
        result = e.getKey();
      }
    }
    return result;
  }

  static char part2(String str) {
    Hashtable<Character, Integer> hash = new Hashtable<Character, Integer>();
    for (char c : str.toCharArray()) {
      if (hash.containsKey(c)) {
        hash.put(c, hash.get(c) + 1);
      } else {
        hash.put(c, 1);
      }
    }
    int min = Integer.MAX_VALUE;
    char result = '0';
    for (Entry<Character, Integer> e : hash.entrySet()) {
      if (e.getValue() < min) {
        min = e.getValue();
        result = e.getKey();
      }
    }
    return result;
  }
}
