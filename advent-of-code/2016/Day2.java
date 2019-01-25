import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day2 {

  String bathroomCode(String[] parts) {
    int[][] keypad = new int[3][3];
    int button = 1, row = 1, col = 1;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        keypad[i][j] = button;
        button++;
      }
    }
    for (String str : parts) {
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == 'U') {
          if (row - 1 >= 0) {
            row--;
            button = keypad[row][col];
          }
        } else if (str.charAt(i) == 'D') {
          if (row + 1 < 3) {
            row++;
            button = keypad[row][col];
          }
        } else if (str.charAt(i) == 'L') {
          if (col - 1 >= 0) {
            col--;
            button = keypad[row][col];
          }
        } else if (str.charAt(i) == 'R') {
          if (col + 1 < 3) {
            col++;
            button = keypad[row][col];
          }
        }
      }
      result.append(button);
    }
    return result.toString();
  }

  String bathroomCode2(String[] parts) {
    char[][] keypad = new char[5][5];
    char[] array = {'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D'};
    int button = 0, row = 2, col = 0;
    char c = '5';
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (i == 0 || i == 4) {
          if (j == 2) {
            keypad[i][j] = array[button];
            button++;
          } else {
            keypad[i][j] = '0';
          }
        } else if (i == 1 || i == 3) {
          if (j >= 1 && j <= 3) {
            keypad[i][j] = array[button];
            button++;
          } else {
            keypad[i][j] = '0';
          }
        } else if (i == 2) {
          keypad[i][j] = array[button];
          button++;
        }
      }
    }
    for (String str : parts) {
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == 'U') {
          if (row - 1 >= 0 && keypad[row - 1][col] != '0') {
            row--;
            c = keypad[row][col];
          }
        } else if (str.charAt(i) == 'D') {
          if (row + 1 < 5 && keypad[row + 1][col] != '0') {
            row++;
            c = keypad[row][col];
          }
        } else if (str.charAt(i) == 'L') {
          if (col - 1 >= 0 && keypad[row][col - 1] != '0') {
            col--;
            c = keypad[row][col];
          }
        } else if (str.charAt(i) == 'R') {
          if (col + 1 < 5 && keypad[row][col + 1] != '0') {
            col++;
            c = keypad[row][col];
          }
        }
      }
      result.append(c);
    }
    return result.toString();
  }

  public static void main(String[] args) {
    String everything = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader("input2.txt"));
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
    System.out.println(new Day2().bathroomCode(parts));
    System.out.println(new Day2().bathroomCode2(parts));
  }
}
