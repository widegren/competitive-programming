package Chapter1;
/**
 * 
 * @author emeliewidegren
 * 
 * Given two strings, write a method to decide if one is a permutation of the other
 */
public class Q3 {
	public static boolean permutation(String str1, String str2){
		int result = 0;
		if(str1.length() != str2.length()){
			return false;
		}
		for(int i = 0; i < str1.length();i++){
			for(int k=0; k < str2.length();k++){
				if(str1.charAt(i) == str2.charAt(k)){
					result += 1;
					break;
				}
			}
		}
		if(result == str1.length()){
			return true;
		}
		else{
			return false;
		}
	}
	public static void main(String[] args){
		String[] words = {"abc", "bca", "ab", "ba", "a"};
		for (int i = 0; i < words.length-1;i++) {
			System.out.println(words[i] + " " + words[i+1] + ": " + permutation(words[i], words[i+1]));
		}
	}
}
