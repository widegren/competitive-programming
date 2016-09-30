
public class Problem14 {
	public static void main(String arg[]) {
		problem14();
	}
	
	public static void problem14(){
		long res = 0, nr = 0;;
		for(int i = 1; i < 1000000;i++){
			long tot = collatz(i);
			if(tot>res){
				res = tot;
				nr = i;
			}
		}
		System.out.println(nr);
	}
	
	public static long collatz(long n){
		long i = 0, res = n;
		while(res != 1){
			if(res%2==0){
				res = res/2;
				i++;
			}
			else{
				res = 3*res+1;
				i++;
			}
		}
		return i;
	}
}
