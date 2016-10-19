package GFG;

import java.util.Scanner;

public class Party {
	public static void main(String[] args){
		int[] arr = new int[100];
		 
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = sc.nextInt();
 
            // Input the array
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }	
 
            // Compute and print result
            System.out.println(search(arr, n));
 
            t--;
        }
        sc.close();
	}
	
	public static String search(int[] array, int n){
		for(int j = 0; j<n;j++){
			for(int k = j+1;k<n;k++){
				if(array[j] == array[k]){
					return "BOYS";
				}
			}
		}
		return "GIRLS";
	}
}
