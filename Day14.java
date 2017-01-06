import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day14 {
	private static final String salt = "ahsbgdzn";
	private static MessageDigest m;
	private static final Pattern triplet = Pattern.compile("(.)\\1\\1");

	public static void main(String[] args) throws Exception {
		m = MessageDigest.getInstance("MD5");

		int result1 = calculate(0);
		int result2 = calculate(2016);

		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
	}

	private static int calculate(int rotations) {
		HashMap<Integer, String> knownHashes = new HashMap<>();
		int counter = 0;
		int foundHashes = 0;

		outerLoop: while (true) {
			String strDigest;
			if (knownHashes.containsKey(counter)) {
				strDigest = knownHashes.get(counter);
			} else {
				strDigest = hashIt(salt + counter, rotations);
				knownHashes.put(counter, strDigest);
			}

			Matcher tripletMatcher = triplet.matcher(strDigest);
			if (tripletMatcher.find(0)) {
				String strTriplet = tripletMatcher.group(0);
				tripletMatcher.reset();

				for (int i = counter + 1; i <= counter + 1001; i++) {
					String nextStrDigest;
					if (knownHashes.containsKey(i)) {
						nextStrDigest = knownHashes.get(i);
					} else {
						nextStrDigest = hashIt(salt + i, rotations);
						knownHashes.put(i, nextStrDigest);
					}

					String quintet = (strTriplet + strTriplet).substring(0, 5);

					if (nextStrDigest.contains(quintet)) {
						foundHashes++;

						if (foundHashes == 64)
							break outerLoop;

						counter++;
						continue outerLoop;
					}
				}
			}

			counter++;
		}
		return counter;
	}

	private static String hashIt(String plaintext, int rotations) {
		String result;
		m.reset();
		m.update(plaintext.getBytes(Charset.forName("UTF-8")));

		byte[] digest = m.digest();

		result = md5BtoS(digest);

		for (int stretch = 0; stretch < rotations; stretch++) {
			m.reset();
			m.update(result.getBytes(Charset.forName("UTF-8")));
			digest = m.digest();
			result = md5BtoS(digest);
		}

		return result;
	}

	private static String md5BtoS(byte[] digest) {
		StringBuilder sb = new StringBuilder();

		for (byte aDigest : digest) {
			if ((0xff & aDigest) < 0x10) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(0xff & aDigest));
		}

		return sb.toString();
	}
}