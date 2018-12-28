package Chapter9;

/**
 * 
 * @author emeliewidegren
 *
 *         A magic index in an array A [0. . .n-1] is defined to be an index
 *         such that A[i]= i. Given a sorted array of distinct integers, write a
 *         method to find a magic index, if one exists, in array A.
 */
public class Q3 {
	public static void main(String[] args) {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.println(findMagicIndex(array, 0, array.length - 1));
	}

	public static boolean findMagicIndex(int[] array, int start, int end) {
		if (end < start || start < 0 || end >= array.length) {
			return false;
		}
		int mid = (start + end) / 2;
		if (array[mid] == mid) {
			return true;
		} else if (array[mid] > mid) {
			return findMagicIndex(array, start, mid - 1);
		} else {
			return findMagicIndex(array, mid + 1, end);
		}
	}
}
