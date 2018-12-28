package Chapter1;
/**
 * 
 * @author emeliewidegren
 * 
 *  Implement an algorithm to determine if a string has all unique characters. 
 *  What if you cannot use additional data structures?
 */
public class Q1 {
	public static boolean isUniqueChars(char c, String str) {
		if(str.length() == 0){
			return true;
		}
		for(int i = 0; i < str.length();i++){
			if(c == str.charAt(i)){
				return false;
			}
		}
		return isUniqueChars(str.charAt(0),str.substring(1));
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "emelie", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word.charAt(0), word.substring(1)));
		}
	}
}
