package Chapter1;

/**
 * 
 * @author emeliewidegren
 * 
 *Implement a method to perform basic string compression using the counts 
 *of repeated characters. For example, the string aabcccccaaa would become 
 *a2blc5a3. If the "compressed" string would not become smaller than the original 
 *string, your method should return the original string.
 */
public class Q5 {
	public static int count(Character c, String str){
		int i = 0;
		for(int k = 0; k < str.length();k++){
			if(c == str.charAt(k)){
				i++;
			}
			else{
				return i;
			}
		}
		return i;
	}
	
	public static String compressed(String str){
		String newstr = "";
		for(int i = 0; i < str.length();){
			int c = count(str.charAt(i),str.substring(i));
			newstr = newstr + str.charAt(i) + c;
			i += c;
		}
		return newstr;
	}
	
	public static void main(String[] args){
		String str = "aabcccccaaa";
		System.out.println(compressed(str));
	}
}
