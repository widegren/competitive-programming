package Chapter1;
/**
 * 
 * @author emeliewidegren
 *
 * Assume you have a method isSubstring which checks if one word is a
 * substring of another. Given two strings, si and s2, write code to check if s2 is
 * a rotation of si using only one call to isSubstring (e.g.,"waterbottle"is a rotation
 * of "erbottlewat").
 */
public class Q8 {
	public static boolean isSubstring(String a, String b){
		if (a.indexOf(b) >= 0) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isRotation(String a, String b){
		if (a.length() == b.length() && a.length() > 0) { 
	    	String newstr = a + a;
	    	return isSubstring(newstr, b);
	    }
	    return false;
	}
	
	public static void main(String[] args){
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean is_rotation = isRotation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + is_rotation);
		}
	}
}
