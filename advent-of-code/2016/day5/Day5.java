public class Day5 {
  public static void main(String[] args) {
    int result = 0, result2 = 0;
    char[] pw = new char[8];
    char[] pw2 = new char[8];
    String data = "wtnhxymk";
    for (int i = 0; ; i++) {
      String str = data + i;
      String hash = MD5(str);
      if (hash.startsWith("00000")) {
        if (result < 8) {
          pw[result] = hash.charAt(5);
          result++;
        }
        int index = Character.getNumericValue(hash.charAt(5));
        if (index < 8 && index >= 0) {
          if (pw2[index] == '\0') {
            pw2[index] = hash.charAt(6);
            result2++;
          }
        }
        if (result == 8 && result2 == 8) {
          break;
        }
      }
    }
    for (char c : pw) System.out.print(c);
    System.out.println();
    for (char c : pw2) System.out.print(c);
  }

  public static String MD5(String md5) {
    try {
      java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
      byte[] array = md.digest(md5.getBytes());
      StringBuffer sb = new StringBuffer();
      for (int i = 0; i < array.length; ++i) {
        sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
      }
      return sb.toString();
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    return null;
  }
}
