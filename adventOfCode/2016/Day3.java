import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day3 {
	public static void main(String[] args) {
		String everything = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader("input3.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			everything = sb.toString();
			br.close();
		} catch (IOException ex) {
			System.out.println(ex.toString());
		}
		everything = everything.trim();
		String[] parts = everything.split("\\s+");
		System.out.println(new Day3().part1(parts));
		System.out.println(new Day3().part2(parts));
	}

	int part1(String[] parts) {
		int result = 0;
		for (int i = 0; i < parts.length; i += 3) {
			if (i + 1 >= parts.length || i + 2 >= parts.length || parts[i].equals("")) {
			} else if (isTriangle(parts[i], parts[i + 1], parts[i + 2])) {
				result++;
			}
		}
		return result;
	}

	int part2(String[] parts) {
		int result = 0;
		for (int i = 0; i < parts.length; i += 9) {
			if (i + 3 >= parts.length || i + 6 >= parts.length || parts[i].equals("")) {
			} else if (isTriangle(parts[i], parts[i + 3], parts[i + 6])) {
				result++;
			}
		}
		for (int i = 1; i < parts.length; i += 9) {
			if (i + 3 >= parts.length || i + 6 >= parts.length || parts[i].equals("")) {
			} else if (isTriangle(parts[i], parts[i + 3], parts[i + 6])) {
				result++;
			}
		}
		for (int i = 2; i < parts.length; i += 9) {
			if (i + 3 >= parts.length || i + 6 >= parts.length || parts[i].equals("")) {
			} else if (isTriangle(parts[i], parts[i + 3], parts[i + 6])) {
				result++;
			}
		}
		return result;
	}

	boolean isTriangle(String a, String b, String c) {
		if (Integer.parseInt(a) + Integer.parseInt(b) > Integer.parseInt(c)) {
			if (Integer.parseInt(a) + Integer.parseInt(c) > Integer.parseInt(b)) {
				if (Integer.parseInt(c) + Integer.parseInt(b) > Integer.parseInt(a)) {
					return true;
				}
			}
		}
		return false;
	}
}