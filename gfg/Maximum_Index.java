package gfg;

import java.util.Scanner;

public class Maximum_Index {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t > 0){
		    int n = sc.nextInt();
		    int[] A = new int[n];
		    
		    for(int i = 0; i < n ; i++){
		        A[i] = sc.nextInt();
		    }
		    System.out.println(findMax(A));
		    t--;
		}
		sc.close();
	}
	
	static int findMax(int[] array){
	    int result = 0;
	    for(int j = array.length-1; j >= 0; j--){
	        for(int i = 0; i < j; i++){
    	        if(array[i] <= array[j] && result < j-i){
    	            result = j-i;
    	        }
	        }
	    }
	    return result;
	}
}
