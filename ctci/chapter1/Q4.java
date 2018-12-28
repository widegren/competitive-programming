package Chapter1;
/**
 * 
 * @author emeliewidegren
 *
 * Write a method to replace all spaces in a string with'%20'. You may assume that 
 * the string has sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if implementing
 * in Java, please use a character array so that you can perform this operation
 * in place.)
 */
public class Q4 {
	public static String replace(String str){
		int index = str.length();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				index += 2;
			}
		}
		char[] array = new char[index];
		
		for (int i = 0; i < str.length(); i++) {
			array[i] = str.charAt(i);
		}
		
		for (int i = str.length() - 1; i >= 0; i--) {
			if (array[i] == ' ') {
				array[index - 1] = '0';
				array[index - 2] = '2';
				array[index - 3] = '%';
				index = index - 3;
			} else {
				array[index - 1] = array[i];
				index--;
			}
		}
		
		String newstr = "";
		for(char c : array){
			newstr += c;
		}
	
		return newstr;
	}
	
	public static void main(String[] args){
		String str = "emelie widegren";
		System.out.println(replace(str));
	}
}
