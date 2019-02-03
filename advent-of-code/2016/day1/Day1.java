import java.io.*;
import java.util.*;

/**
 * Java solution for Advent of Code Day 1: No Time for a Taxicab
 *
 * @author Emelie Widegren <emeliewide@gmail.com>
 */
public class Day1 {

  /** Directions that can be used in a sequence. */
  enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
  }

  /** Calculate the shortest path to Easter Bunny HQ from given a sequence. */
  private int findShortestPath(String[] parts) {
    int x = 0;
    int y = 0;
    Direction direction = Direction.NORTH;
    for (String i : parts) {
      if (i.charAt(0) == 'R') {
        switch (direction) {
          case NORTH:
            x += Integer.parseInt(i.substring(1));
            direction = Direction.EAST;
            break;
          case SOUTH:
            x -= Integer.parseInt(i.substring(1));
            direction = Direction.WEST;
            break;
          case EAST:
            y -= Integer.parseInt(i.substring(1));
            direction = Direction.SOUTH;
            break;
          case WEST:
            y += Integer.parseInt(i.substring(1));
            direction = Direction.NORTH;
            break;
        }
      } else {
        switch (direction) {
          case NORTH:
            x -= Integer.parseInt(i.substring(1));
            direction = Direction.WEST;
            break;
          case SOUTH:
            x += Integer.parseInt(i.substring(1));
            direction = Direction.EAST;
            break;
          case EAST:
            y += Integer.parseInt(i.substring(1));
            direction = Direction.NORTH;
            break;
          case WEST:
            y -= Integer.parseInt(i.substring(1));
            direction = Direction.SOUTH;
            break;
        }
      }
    }
    return Math.abs(x) + Math.abs(y);
  }

  /** Calculate the distance to the first location visited twice */
  private int firstRepeatedCoordinates(String[] parts) {
    Set<String> set = new HashSet<String>();

    int x = 0, y = 0;
    set.add("x:" + x + ",y:" + y);

    Direction direction = Direction.NORTH;

    for (String i : parts) {
      if (i.charAt(0) == 'R') {
        for (int j = 0; j < Integer.parseInt(i.substring(1)); j++) {
          switch (direction) {
            case NORTH:
              x++;
              break;
            case SOUTH:
              x--;
              break;
            case EAST:
              y--;
              break;
            case WEST:
              y++;
              break;
          }
          if (set.contains("x:" + x + ",y:" + y)) {
            return Math.abs(x) + Math.abs(y);
          }
          set.add("x:" + x + ",y:" + y);
        }
        switch (direction) {
          case NORTH:
            direction = Direction.EAST;
            break;
          case SOUTH:
            direction = Direction.WEST;
            break;
          case EAST:
            direction = Direction.SOUTH;
            break;
          case WEST:
            direction = Direction.NORTH;
            break;
        }
      } else {
        for (int j = 0; j < Integer.parseInt(i.substring(1)); j++) {
          switch (direction) {
            case NORTH:
              x--;
              break;
            case SOUTH:
              x++;
              break;
            case EAST:
              y++;
              break;
            case WEST:
              y--;
              break;
          }
          if (set.contains("x:" + x + ",y:" + y)) {
            return Math.abs(x) + Math.abs(y);
          }
          set.add("x:" + x + ",y:" + y);
        }
        switch (direction) {
          case NORTH:
            direction = Direction.WEST;
            break;
          case SOUTH:
            direction = Direction.EAST;
            break;
          case EAST:
            direction = Direction.NORTH;
            break;
          case WEST:
            direction = Direction.SOUTH;
            break;
        }
      }
    }
    return Math.abs(x) + Math.abs(y);
  }

  /**
   * Read the input file and call findShortestPath to solve part one and firstRepeatedCoordinates to
   * solve part two
   */
  public static void main(String[] args) {
    String everything = "";
    try {
      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
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
    everything = everything.replaceAll("\\s+", "");
    String[] parts = everything.split(",");
    System.out.println(new Day1().findShortestPath(parts));
    System.out.println(new Day1().firstRepeatedCoordinates(parts));
  }
}
