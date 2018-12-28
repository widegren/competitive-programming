import java.awt.*;
import java.util.*;

public class Day13 {
	String[][] matrix;
	boolean[][] visited;
	int row, column, favoriteNr = 1352;

	public static void main(String[] args) {
		Day13 d = new Day13();
		d.initialise(50, 50);
		d.print();
		d.bfs();
		d.initialise(50, 50);
		d.bfs2();
	}

	void bfs2() {
		Queue<Point> queue = new LinkedList<Point>();
		HashSet<Point> set = new HashSet<Point>();
		ArrayList<Point> path = new ArrayList<Point>();
		queue.add(new Point(1, 1));
		visited[1][1] = true;

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			path.add(p);
			int dist = 1;
			Point prev = path.get(path.size() - 1);
			for (int i = path.size() - 2; i >= 1; i--) {
				if (Math.abs(prev.getX() - path.get(i).getX()) == 1 && prev.getY() - path.get(i).getY() == 0
						|| prev.getX() - path.get(i).getX() == 0 && Math.abs(prev.getY() - path.get(i).getY()) == 1) {
					dist++;
					prev = path.get(i);
				}
			}
			if (dist <= 50)
				set.add(p);

			if (p.getY() - 1 >= 0 && isOpen((int) p.getX(), (int) p.getY() - 1)
					&& !visited[(int) p.getY() - 1][(int) p.getX()]) {
				queue.add(new Point((int) p.getX(), (int) p.getY() - 1));
				visited[(int) p.getY() - 1][(int) p.getX()] = true;
			}
			if (p.getX() - 1 >= 0 && isOpen((int) p.getX() - 1, (int) p.getY())
					&& !visited[(int) p.getY()][(int) p.getX() - 1]) {
				queue.add(new Point((int) p.getX() - 1, (int) p.getY()));
				visited[(int) p.getY()][(int) p.getX() - 1] = true;
			}
			if (p.getX() + 1 <= column - 2 && isOpen((int) p.getX() + 1, (int) p.getY())
					&& !visited[(int) p.getY()][(int) p.getX() + 1]) {
				queue.add(new Point((int) p.getX() + 1, (int) p.getY()));
				visited[(int) p.getY()][(int) p.getX() + 1] = true;
			}
			if (p.getY() + 1 <= row - 2 && isOpen((int) p.getX(), (int) p.getY() + 1)
					&& !visited[(int) p.getY() + 1][(int) p.getX()]) {
				queue.add(new Point((int) p.getX(), (int) p.getY() + 1));
				visited[(int) p.getY() + 1][(int) p.getX()] = true;
			}
		}
		System.out.println(set.size());
	}

	void bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		ArrayList<Point> path = new ArrayList<Point>();
		queue.add(new Point(1, 1));
		visited[1][1] = true;

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			path.add(p);

			if (p.getX() == 31 && p.getY() == 39) {
				break;
			}

			if (p.getY() - 1 >= 0 && isOpen((int) p.getX(), (int) p.getY() - 1)
					&& !visited[(int) p.getY() - 1][(int) p.getX()]) {
				queue.add(new Point((int) p.getX(), (int) p.getY() - 1));
				visited[(int) p.getY() - 1][(int) p.getX()] = true;
			}
			if (p.getX() - 1 >= 0 && isOpen((int) p.getX() - 1, (int) p.getY())
					&& !visited[(int) p.getY()][(int) p.getX() - 1]) {
				queue.add(new Point((int) p.getX() - 1, (int) p.getY()));
				visited[(int) p.getY()][(int) p.getX() - 1] = true;
			}
			if (p.getX() + 1 <= column - 2 && isOpen((int) p.getX() + 1, (int) p.getY())
					&& !visited[(int) p.getY()][(int) p.getX() + 1]) {
				queue.add(new Point((int) p.getX() + 1, (int) p.getY()));
				visited[(int) p.getY()][(int) p.getX() + 1] = true;
			}
			if (p.getY() + 1 <= row - 2 && isOpen((int) p.getX(), (int) p.getY() + 1)
					&& !visited[(int) p.getY() + 1][(int) p.getX()]) {
				queue.add(new Point((int) p.getX(), (int) p.getY() + 1));
				visited[(int) p.getY() + 1][(int) p.getX()] = true;
			}
		}
		int dist = 1;
		Point prev = path.get(path.size() - 1);
		for (int i = path.size() - 2; i >= 1; i--) {
			if (Math.abs(prev.getX() - path.get(i).getX()) == 1 && prev.getY() - path.get(i).getY() == 0
					|| prev.getX() - path.get(i).getX() == 0 && Math.abs(prev.getY() - path.get(i).getY()) == 1) {
				dist++;
				prev = path.get(i);
			}
		}
		System.out.println(dist);
	}

	boolean isOpen(int x, int y) {
		int sum = x * x + 3 * x + 2 * x * y + y + y * y;
		sum += favoriteNr;
		if (Integer.bitCount(sum) % 2 == 0) {
			return true;
		}
		return false;
	}

	void initialise(int row, int column) {
		this.row = row;
		this.column = column;
		matrix = new String[row][column];
		visited = new boolean[row][column];
		int count = 0;
		matrix[0][0] = "-";

		for (int i = 1; i < row; i++) {
			matrix[i][0] = Integer.toString(count);
			count++;
		}
		count = 0;
		for (int j = 1; j < column; j++) {
			matrix[0][j] = Integer.toString(count);
			count++;
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < column; j++) {
				if (isOpen(j - 1, i - 1)) {
					if (j > 9 || i < 11)
						matrix[i][j] = " .";
					else if (j == 1)
						matrix[i][j] = ".";
					else
						matrix[i][j] = " .";
				} else {
					if (j > 9 || i < 11)
						matrix[i][j] = " #";
					else if (j == 1)
						matrix[i][j] = "#";
					else
						matrix[i][j] = " #";
				}
				visited[i][j] = false;
			}
		}
	}

	void print() {
		System.out.print("-");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(matrix[i][j] + " ");
				if (i == 0 && j > 0 && j < 11)
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
