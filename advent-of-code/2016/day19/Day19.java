import java.util.*;

public class Day19 {
  public static void main(String[] args) {
    int group = 3001330;
    System.out.println(new Day19().part1(group));
    System.out.println(new Day19().part2(group));
  }

  int part2(int group) {
    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> queue2 = new LinkedList<>();

    for (int i = 1; i <= group; i++) {
      if (i <= group / 2) queue1.addLast(i);
      else queue2.addLast(i);
    }

    while (queue1.size() + queue2.size() != 1) {
      int x = queue1.pollFirst();
      if (queue1.size() == queue2.size()) {
        queue1.pollLast();
      } else {
        queue2.pollFirst();
      }
      queue2.addLast(x);
      int a = queue2.pollFirst();
      queue1.addLast(a);
    }
    return queue1.pollFirst();
  }

  int part1(int group) {
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= group; i++) {
      queue.addLast(i);
    }
    boolean take = false;
    while (queue.size() != 1) {
      Iterator<Integer> itr = queue.iterator();
      while (itr.hasNext()) {
        itr.next();
        if (take) itr.remove();
        take = !take;
      }
    }
    return queue.pollFirst();
  }
}
