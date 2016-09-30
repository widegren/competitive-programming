import java.math.BigInteger;
import java.util.ArrayList;

public class ProjectEuler {

	public static void problem1() {
		int result = 0;
		for (int i = 0; i < 1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				result = result + i;
			}
		}
		System.out.println(result);
	}

	public static void problem2() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int result = 0, i = 0, fib = 1;

		while (fib < 4000000) {
			list.add(fib);
			if (i != 0) {
				fib = fib + list.get(i - 1);
				if (fib % 2 == 0) {
					result = result + fib;
				}
			}
			i++;
		}
		System.out.println(result);
	}

	public static void problem3() {
		BigInteger num = new BigInteger("600851475143");
		BigInteger factors;
		int i = 2;
		BigInteger k = new BigInteger("2");
		while (BigInteger.valueOf(i).compareTo(num) < 0) {
			factors = num.mod(k);
			if (BigInteger.valueOf(0).compareTo(factors) == 0 && isPrime(i)) {
				System.out.println(i + "");
			}
			i++;
			k = k.add(BigInteger.ONE);
		}
	}

	public static boolean isPrime(int n) {
		if (n % 2 == 0 && n!=2)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void problem4() {
		int prod, res = 0;
		for (int i = 10; i < 1000; i++) {
			for (int k = 10; k < 1000; k++) {
				prod = i * k;
				if (Integer.toString(prod).length() % 2 == 0) {
					if (isPalindrome(Integer.toString(prod)) && prod > res) {
						res = prod;
					}
				}
			}
		}
		System.out.println(res);
	}

	public static boolean isPalindrome(String s) {
		int l = s.length() - 1;
		for (int n = 0; l > n; l--, n++) {
			if (s.charAt(n) == s.charAt(l)) {
				continue;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void problem5() {
		for (int i = 20;; i++) {
			if (divisible(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	public static boolean divisible(int n) {
		for (int k = 20; k > 0; k--) {
			if (n % k == 0)
				continue;
			else
				return false;
		}
		return true;
	}

	public static void problem6() {
		int res = 0, res1 = 0, square;
		for (int i = 1; i < 101; i++) {
			res = res + i * i;
			res1 = res1 + i;
		}
		res1 = res1 * res1;
		square = res1 - res;
		System.out.println(square);
	}

	public static void problem7() {
		int nr = 1;
		for (int i = 1;; i++) {
			if (isPrime(i) && i > 1) {
				nr++;
			}
			if (nr == 10001) {
				System.out.println(i);
				break;
			}
		}
	}

	public static void problem8() {
		long res = 0;
		String s = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		for(int i=0;i<s.length();i++){
			try{
				String sub = s.substring(i, i+13);
				long prod = 1;
				for(int k=0;k<sub.length();k++){
					prod = prod * Character.getNumericValue(sub.charAt(k));
				}
				if(prod>=res){
					res = prod;
				}
			}
			catch(Exception e){
				
			}
		}
		System.out.println(res);
	}
	
	public static void problem9(){
		System.out.println(pythagorean());
	}
	
	public static int pythagorean(){
		for(int a = 1;;a++){
			for(int b=1;;b++){
				double c = a*a+b*b;
				c = Math.sqrt(c);
				double tot = a+b+c;
				double prod = a*b*c;
				if(tot == 1000){
					return (int) prod;
				}
				if(tot > 1000)
					break;
			}
		}
	}
	
	public static void problem10(){
		long res = 0;
		for(int i=2;i<2000000;i++){
			if(isPrime(i)){
				res = res + i;
			}
		}
		System.out.println(res);
	}
	

	public static void main(String arg[]) {
		problem10();
	}
}
