import java.util.ArrayList;

/**
 * 
 * @author emeliewidegren
 *
 *         What is the millionth lexicographic permutation of the digits 0, 1,
 *         2, 3, 4, 5, 6, 7, 8 and 9?
 * 
 */
public class Problem24 {
	static ArrayList<String> list = new ArrayList<String>();
	public static void main(String[] args) {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int limit = 1000000;
		String str = "";
		while(nextPermutation(array)){
			if(limit == 0){
				for(int c : array){
					str = str + c;
				}
				System.out.println(str);
				break;
			}
			limit--;
		}
	}

	public static boolean nextPermutation(int[] array) {
	    // Find non-increasing suffix
	    int i = array.length - 1, j = array.length-1;
	    while (i > 0 && array[i - 1] >= array[i]){
	        i--;
	    }
	    if (i <= 0){
	        return false;
	    }
	    
	    // Find successor to pivot
	    while (array[j] <= array[i - 1]){
	        j--;
	    }
	    int temp = array[i - 1];
	    array[i - 1] = array[j];
	    array[j] = temp;
	    
	    // Reverse suffix
	    j = array.length - 1;
	    while (i < j) {
	        temp = array[i];
	        array[i] = array[j];
	        array[j] = temp;
	        i++;
	        j--;
	    }
	    return true;
	}
}
