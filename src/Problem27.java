
public class Problem27 {
	public static void main(String[] args){
		int aMax = 0, bMax = 0, nMax = 0;
		for(int a = -999;a<1000;a++){
			for(int b = -999; b < 1000; b++){
				int n = 0;
				while (isPrime(Math.abs(n * n + a * n + b))) {
		            n++;
		        }
		 
		        if (n > nMax) {
		            aMax = a;
		            bMax = b;
		            nMax = n;
		        }
			}
		}
		System.out.println(aMax + " " + bMax + " " + nMax);
	}

	private static boolean isPrime(int prime) {
		for(int i = 2; i < prime; i++){
			if(prime%i == 0){
				return false;
			}
		}
		return true;
	}
}
