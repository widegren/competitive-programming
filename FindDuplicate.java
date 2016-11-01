import java.util.*;

public class FindDuplicate {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 4, 2 };
		System.out.println(find(array));
		System.out.println(findDup(array));
		System.out.println((findDuplicates(array)));
		System.out.println(reverse("Emelie"));
		Fibonacci(10);
		System.out.println(getFibonacci(10));
		System.out.println(isPalindrome(121));
		System.out.println(firstNonRepeatedCharacter("abcdefghija"));
		System.out.println(isEven(4));

		int[] numbers = { 1, 20, 22, 102, 101, 1221, 13321, 13331, 0, 11 };

		for (int number : numbers) {
			System.out.print(number + " " + isPalindromeInt(number) + ", ");
		}
	}
	
	public static boolean isEven(int n){
		return n%2 == 0;
	}

	public static char firstNonRepeatedCharacter(String word) {
		HashMap<Character, Integer> scoreboard = new HashMap<>();
		
		for (char c : word.toCharArray()) {
			if (scoreboard.containsKey(c)) {
				scoreboard.put(c, scoreboard.get(c) + 1);
			} else {
				scoreboard.put(c, 1);
			}
		}
		for (char c : word.toCharArray()) {
			if (scoreboard.get(c) == 1) {
				return c;
			}
		}
		throw new RuntimeException("Undefined behaviour");
	}

	public static int find(int[] array) {
		HashSet<Integer> set = new HashSet<Integer>();
		int result = -1;
		for (int i : array) {
			if (!set.contains(i)) {
				set.add(i);
			} else {
				result = i;
				break;
			}
		}
		return result;
	}

	public static boolean findDup(int[] array) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : array) {
			if (!set.add(i)) {
				return true;
			}
		}
		return false;
	}

	public static String reverse(String str) {
		String strcopy = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			strcopy += str.charAt(i);
		}
		return strcopy;
	}

	public static HashSet<Integer> findDuplicates(int[] array) {
		HashSet<Integer> set = new HashSet<Integer>();
		HashSet<Integer> duplicates = new HashSet<Integer>();

		for (int i : array) {
			if (!set.contains(i)) {
				set.add(i);
			} else if (!duplicates.contains(i)) {
				duplicates.add(i);
			}
		}
		return duplicates;
	}

	public static void Fibonacci(int n) {
		int[] array = new int[n];

		array[0] = 1;
		array[1] = 1;

		for (int i = 2; i < n; i++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println("");
	}

	public static int getFibonacci(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 1;
		}
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}

	public static boolean isPalindrome(int n) {
		String str = Integer.toString(n);

		if (str.length() < 2) {
			return true;
		} else if (str.charAt(0) == str.charAt(str.length() - 1)) {
			if (str.length() == 2) {
				return true;
			} else {
				return isPalindrome(Integer.parseInt(str.substring(1, str.length() - 1)));
			}
		} else {
			return false;
		}
	}

	private static boolean isPalindromeInt(int number) {
		if (number == reverse(number)) {
			return true;
		}
		return false;
	}

	private static int reverse(int number) {
		int reverse = 0;

		while (number != 0) {
			reverse = reverse * 10 + number % 10;
			number = number / 10;
		}

		return reverse;
	}
}
