package Chapter3;

import java.util.*;

/**
 * 
 * @author emeliewidegren
 *
 * Write a program to sort a stack in ascending order (with biggest items on top).
 * You may use at most one additional stack to hold items, but you may not copy
 * the elements into any other data structure (such as an array). The stack supports
 * the following operations: push, pop, peek, and isEmpty.
 */
public class Q6 {
	public static void main(String[] args){
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(2);
		stack.push(4);
		stack.push(3);
		stack.push(5);
		stack.push(1);
		
		stack = sort(stack);
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
	
	public static Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r = new Stack<Integer>();
		while(!s.isEmpty()) {
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
}
