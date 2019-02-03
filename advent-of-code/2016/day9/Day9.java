import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day9 {
  public static void main(String[] args) {
    String everything = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader("input9.txt"));
      String line = br.readLine();
      everything = line;
      br.close();
    } catch (IOException ex) {
      System.out.println(ex.toString());
    }
    System.out.println(new Day9().decompress(everything).length());
    System.out.println(new Day9().solve(everything, true));
  }

  public String decompress(String str) {
    int length = str.length(), reps, chars;
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
      if (str.charAt(i) == '(') {
        int j = i;
        while (str.charAt(j) != ')') {
          j++;
        }
        String tmp = str.substring(i + 1, j);
        String parts[] = tmp.split("x");
        chars = Integer.parseInt(parts[0]);
        reps = Integer.parseInt(parts[1]);
        if (chars > str.substring(j + 1).length()) {
          i = j;
          break;
        }
        String s = str.substring(j + 1, j + 1 + chars);
        for (int k = 0; k < reps; k++) {
          sb.append(s);
        }
        i = j + chars;
      } else {
        sb.append(str.charAt(i));
      }
    }
    return sb.toString();
  }

  public long solve(String s, boolean partTwo) {
    long cnt = 0;
    char[] s_arr = s.toCharArray();
    for (int i = 0; i < s_arr.length; i++) {
      if (s_arr[i] == ' ') {
        continue;
      } else if (s_arr[i] == '(') {
        int end = s.indexOf(')', i);
        int howMuch = Integer.valueOf(s.substring(i + 1, end).split("x")[0]);
        int times = Integer.valueOf(s.substring(i + 1, end).split("x")[1]);
        String repeat = s.substring(end + 1, end + 1 + howMuch);
        cnt += times * ((partTwo) ? solve(repeat, partTwo) : repeat.length());
        i = end + howMuch;
      } else {
        cnt++;
      }
    }
    return cnt;
  }
}
