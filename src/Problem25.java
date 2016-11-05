import java.math.BigInteger;

public class Problem25 {
	public static void main(String[] args){
		BigInteger[] fib = new BigInteger[10000];
		fib[0] = BigInteger.ONE;
		fib[1] = BigInteger.ONE;
		
		BigInteger limit = new BigInteger("10").pow(999);
		
		int i = 1;
		while(fib[i].compareTo(limit) < 0 || fib[i].compareTo(limit) == 0){
			i++;
			fib[i] = fib[i-1].add(fib[i-2]);
		}
		System.out.println(i+1);
	}
}
