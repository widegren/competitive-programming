public class Day16 {
  private static final Integer DISC_LENGTH = 272;
  private static final Integer DISC_LENGTH_2 = 35651584;
  private static final String INPUT = "10010000000110000";

  public static void main(String[] args) {
    System.out.println("Part 1: " + calculateChecksum(getFiller(INPUT, DISC_LENGTH)));
    System.out.println("Part 2: " + calculateChecksum(getFiller(INPUT, DISC_LENGTH_2)));
  }

  private static String calculateChecksum(String input) {
    while (input.length() % 2 == 0) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < input.length() - 1; i += 2) {
        sb.append(input.charAt(i) == input.charAt(i + 1) ? '1' : '0');
      }
      input = sb.toString();
    }
    return input;
  }

  private static String getFiller(String input, Integer discLength) {
    while (input.length() < discLength) {
      char[] answer = new char[input.length() * 2 + 1];
      for (int i = 0; i < input.length(); i++) {
        answer[i] = input.charAt(i);
        answer[answer.length - i - 1] = input.charAt(i) == '0' ? '1' : '0';
      }
      answer[input.length()] = '0';
      input = new String(answer);
    }
    return input.substring(0, discLength);
  }
}
