import java.io.*;
import java.util.HashMap;

public class Day12 {
	static HashMap<Character, Integer> map = new HashMap<Character, Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input12.txt"));
		StringBuilder sb = new StringBuilder();
		String line, everything;
		int[][] screen = new int[6][50];

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 50; j++) {
				screen[i][j] = 0;
			}
		}

		while ((line = br.readLine()) != null) {
			sb.append(line);
			sb.append(System.lineSeparator());
		}

		br.close();
		everything = sb.toString();
		String[] parts = everything.split("\\n");
		map.put('a', 0);
		map.put('b', 0);
		// map.put('c', 0);
		map.put('c', 1);
		map.put('d', 0);

		int currentLineIndex = 0;
		while (currentLineIndex < parts.length) {
			String[] data = parts[currentLineIndex].split("\\s+");
			String cmd = data[0];
			if (cmd.equals("cpy")) {
				char toReg = data[2].charAt(0);
				if (!Character.isDigit(data[1].charAt(0))) {
					cpy(data[1].charAt(0), toReg);
				} else {
					cpy(Integer.parseInt(data[1]), toReg);
				}
				currentLineIndex++;
			} else if (cmd.equals("inc")) {
				int value = map.get(data[1].charAt(0));
				map.put(data[1].charAt(0), value + 1);
				currentLineIndex++;
			} else if (cmd.equals("dec")) {
				int value = map.get(data[1].charAt(0));
				map.put(data[1].charAt(0), value - 1);
				currentLineIndex++;
			} else if (cmd.equals("jnz")) {
				int value;

				if (!Character.isDigit(data[1].charAt(0))) {
					char reg = data[1].charAt(0);
					value = map.get(reg);
				} else {
					value = Integer.parseInt(data[1]);
				}

				if (value != 0) {
					currentLineIndex += Integer.parseInt(data[2]);
				} else {
					currentLineIndex += 1;
				}
			}
		}
		System.out.println(map.get('a'));
	}

	private static void cpy(char fromRegister, char toRegister) {
		int value = map.get(fromRegister);
		cpy(value, toRegister);
	}

	private static void cpy(int value, char register) {
		map.put(register, value);
	}
}
