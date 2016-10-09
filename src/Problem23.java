import java.util.ArrayList;

public class Problem23 {
	public static void main(String arg[]){
		ArrayList<Integer> list = new ArrayList<Integer>();
		ArrayList<Integer> sum = new ArrayList<Integer>();
		int result = 0;
		for(int i = 0; i < 28124 ; i++){
			if(abdundant(i)){
				list.add(i);
			}
		}
		
		for (int i=0; i<list.size(); i++) {
	        for (int j=i ; j<list.size(); j++) {
	            int tmp = list.get(i) + list.get(j);
	            if (tmp < 28124) {
	                sum.add(tmp);
	            }
	        }
	    }

	    for (int i=1; i<28124; i++) {
	        if (sum.contains(i) == false) {
	            result += i;
	        }
	    }
	    System.out.println(result);
	}
	
	public static boolean abdundant(long number){
		int sum=0;
	    for (int i=1; i<number; i++) {
	        if (number%i==0) {
	            sum += i;
	        }
	    }
	    if (sum>number) { return true; }
	    else { return false; }
	}
}
