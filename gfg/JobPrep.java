package gfg;

public class JobPrep {
	public static void main(String[] args){
		int n = 547;
		
		for(int i = 2; i < n; i++){
			if(n%i == 0){
				System.out.println(n + " is not a prime");
				break;
			}
		}
		System.out.println(n + " is a prime");
	}
}
