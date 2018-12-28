
public class Problem17 {
	public static String[] ones = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };

	public static String[] tens = { "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
			"ninety" };

	public static String[] hundreds = { "", "onehundred", "twohundred", "threehundred", "fourhundred", "fivehundred",
			"sixhundred", "sevenhundred", "eighthundred", "ninehundred", "onethousand" };

	public static void main(String arg[]) {
		problem17();
	}

	public static void problem17() {
		int result = 0;
		for (int i = 1; i < 1001; i++) {
			if (i < 20) {
				result = result + ones[i].length();
			} else if (i < 100) {
				result = result + tens[i / 10].length() + ones[i % 10].length();
			} else if (i < 1001) {
				if (i % 100 > 0) {
					result = result + "and".length();
				}
				if (i % 100 < 20) {
					result = result + hundreds[i / 100].length() + ones[i % 100].length();
				} else {
					result = result + hundreds[i / 100].length() + tens[(i % 100) / 10].length()
							+ ones[i % 10].length();
				}
			}
		}
		System.out.println(result);
	}
}
