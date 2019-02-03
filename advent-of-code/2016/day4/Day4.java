import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Day4 {
  public static void main(String[] args) {
    String everything = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader("input4.txt"));
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
    System.out.println(new Day4().isRealRoom(parts));
    System.out.println(new Day4().decrypt(parts));
  }

  int isRealRoom(String[] parts) {
    int result = 0;
    for (int i = 0; i < parts.length; i++) {
      String str = parts[i];
      ArrayList<Integer> list = new ArrayList<Integer>();
      ArrayList<Character> chars = new ArrayList<Character>();
      TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
      String id = "", realcheck = "", checksum = "";
      for (int j = 0; j < str.length(); j++) {
        if (str.charAt(j) == '-') {
        } else if (str.charAt(j) == '[' || str.charAt(j) == ']') {
          for (int k = j + 1; k < str.length() - 1; k++) {
            realcheck += str.charAt(k);
          }
          break;
        } else if (str.charAt(j) <= '9' && str.charAt(j) >= '0') {
          id += str.charAt(j);
        } else if (map.containsKey(str.charAt(j))) {
          map.put(str.charAt(j), map.get(str.charAt(j)) + 1);
        } else {
          map.put(str.charAt(j), 1);
          chars.add(str.charAt(j));
        }
      }
      for (Entry<Character, Integer> entry : map.entrySet()) {
        list.add(entry.getValue());
      }

      Collections.sort(list);
      Collections.sort(chars);

      for (int j = list.size() - 1; j >= list.size() - 5; j--) {
        for (Entry<Character, Integer> entry : map.entrySet()) {
          if (entry.getValue() == list.get(j)) {
            checksum += entry.getKey();
            map.remove(entry.getKey());
            break;
          }
        }
      }
      if (realcheck.equals(checksum)) {
        result += Integer.parseInt(id);
      }
    }
    return result;
  }

  int decrypt(String[] parts) {
    for (int i = 0; i < parts.length; i++) {
      String str = parts[i];
      String id = "", decrypted = "";
      for (int j = 0; j < str.length(); j++) {
        if (str.charAt(j) <= '9' && str.charAt(j) >= '0') {
          id += str.charAt(j);
        }
      }
      for (int j = 0; j < str.length(); j++) {
        if (str.charAt(j) == '-') {
          decrypted += " ";
        } else if (str.charAt(j) <= '9' && str.charAt(j) >= '0') {
        } else if (str.charAt(j) == '[' || str.charAt(j) == ']') {
          break;
        } else {
          char c = str.charAt(j);
          for (int k = 0; k < Integer.parseInt(id); k++) {
            if (c == 'z') {
              c = 'a';
            } else {
              c++;
            }
          }
          decrypted += c;
        }
      }
      if (decrypted.equals("northpole object storage ")) {
        return Integer.parseInt(id);
      }
    }
    return 0;
  }
}
