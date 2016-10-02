import java.math.BigInteger;

public class Problem16 {
	public static void main(String arg[]) {
		problem16();
	}
	
	public static void problem16(){
		BigInteger copy = BigInteger.valueOf(0), result = BigInteger.valueOf(0), nr = BigInteger.valueOf(2), mod = BigInteger.valueOf(10);
		nr = nr.pow(1000);
		
		copy = nr;
		while (copy.compareTo(BigInteger.valueOf(0)) > 0) {
			copy = nr.mod(mod);
		    nr = nr.divide(mod);
		    while(nr.mod(mod) == BigInteger.valueOf(0) && nr.compareTo(BigInteger.valueOf(0)) > 0){
		    	nr = nr.divide(mod);
		    }
		    result = result.add(copy);
		}
		System.out.println(result);
	}
}
