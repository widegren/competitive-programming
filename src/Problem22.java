import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Problem22 {
	
	public static void main(String arg[]) throws FileNotFoundException, IOException{
		String[] names;
		try(BufferedReader br = new BufferedReader(new FileReader("names.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString().replaceAll("\"","").replaceAll("\\s+", "");
		    names = everything.split(",");
		    Arrays.sort(names);
		}
		
		long total = 0;
		for(int i = 0; i < names.length;i++){
			String name = names[i];
			long result = 0;
			for(int k = 0; k < name.length(); k++) {
				   result += (int)name.charAt(k)-64;
			}
			total += result*(i+1);
		}
		System.out.println(total);
	}
}
