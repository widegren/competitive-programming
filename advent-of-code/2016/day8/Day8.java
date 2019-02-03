import java.io.*;

public class Day8 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    StringBuilder sb = new StringBuilder();
    String line, everything;
    int[][] screen = new int[6][50];

    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 50; j++) {
        screen[i][j] = 0;
      }
    }

    while ((line = br.readLine()) != null) {
      sb.append(line);
      sb.append(System.lineSeparator());
    }

    br.close();
    everything = sb.toString();
    String[] parts = everything.split("\\n");
    for (String s : parts) {
      String[] p = s.split("\\s+");
      if (p[0].equals("rect")) {
        int column = Integer.parseInt(p[1].split("x")[0]);
        int row = Integer.parseInt(p[1].split("x")[1]);
        for (int i = 0; i < row; i++) {
          for (int j = 0; j < column; j++) {
            screen[i][j] = 1;
          }
        }
      } else if (p[0].equals("rotate")) {
        if (p[1].equals("row")) {
          int y = Integer.parseInt(p[2].split("=")[1]);
          int nr = Integer.parseInt(p[4]);
          int[] tmp = new int[50];
          for (int j = 0; j < 50; j++) {
            if (j - nr < 0) tmp[j] = screen[y][50 + (j - nr)];
            else tmp[j] = screen[y][j - nr];
          }
          for (int j = 50 - 1; j >= 0; j--) {
            screen[y][j] = tmp[j];
          }
        } else if (p[1].equals("column")) {
          int x = Integer.parseInt(p[2].split("=")[1]);
          int nr = Integer.parseInt(p[4]);
          int[] tmp = new int[6];
          for (int i = 0; i < 6; i++) {
            if (i - nr < 0) tmp[i] = screen[6 + (i - nr)][x];
            else tmp[i] = screen[i - nr][x];
          }
          for (int i = 6 - 1; i >= 0; i--) {
            screen[i][x] = tmp[i];
          }
        }
      }
    }
    int result = 0, count = 0;
    for (int i = 0; i < 6; i++) {
      for (int j = 0; j < 50; j++) {
        System.out.print(screen[i][j] + " ");
        if (screen[i][j] == 1) result++;
        count++;
        if (count == 5) {
          System.out.print(" ");
          count = 0;
        }
      }
      System.out.println();
    }
    System.out.println(result);
  }
}
