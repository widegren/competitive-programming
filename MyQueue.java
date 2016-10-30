import java.util.Stack;

public class MyQueue<T> {
	Stack<T> stackNewest, stackOldest;

	public MyQueue() {
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}

	public int size() {
		return stackNewest.size() + stackOldest.size();
	}

	public void add(T value) {
		stackNewest.push(value);
	}

	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}

	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}

	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		while (queue.size() != 0) {
			long value = queue.remove();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");
	}
}
