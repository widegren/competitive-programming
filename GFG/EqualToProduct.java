package GFG;

import java.util.Scanner;

public class EqualToProduct {
	public static void main(String[] args){
		int[] arr = new int[1000];
		 
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
 
        // One by one run for all input test cases
        while (t > 0)
        {
            // Input the size of the array
            int n = sc.nextInt();
            int prod = sc.nextInt();
 
            // Input the array
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }	
 
            // Compute and print result
            System.out.println(product(arr, n, prod));
 
            t--;
        }
        sc.close();
	}
	
	public static String product(int[] array, int n, int prod){
		for(int i = 0; i < n;i++){
			for(int j = i+1;j<n;j++){
				if(array[i]*array[j] == prod){
					return "Yes";
				}
			}
		}
		return "No";
	}
}
