package gfg;

import java.util.*;

/**
 * 
 * @author emeliewidegren
 *
 *         3 ((() )()()) ()(()))))
 */
public class LongestValidParentheses {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			String str = sc.next();
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(-1);
			int result = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') {
					stack.push(i);
				} else {
					stack.pop();
					if (!stack.empty())
						result = result > i - stack.peek() ? result : i - stack.peek();
					else
						stack.push(i);
				}
			}
			System.out.println(result);
			t--;
		}
		sc.close();
	}
}