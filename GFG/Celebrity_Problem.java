package gfg;

import java.util.*;

public class Celebrity_Problem {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int N = sc.nextInt();
			int M[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					M[i][j] = sc.nextInt();
				}
			}
			System.out.println(getId(M, N));
			t--;
		}
		sc.close();
	}

	static int getId(int M[][], int n) {
		int left = 0;
        int right = n - 1;
         
        // Step 1: Find the potential candidate
        while (left < right) {
            if (haveAcquaintance(M[left], right)) {
                left++;
            } else {
                right--;
            }
        }
         
        // Step 2: Validate the candidate
        int candidate = right;
        for (int i = 0; i < n; i++) {
            if (i != candidate && (!haveAcquaintance(M[i], candidate) || haveAcquaintance(M[candidate], i))) {
                return -1;
            }
        } 
        return candidate;
	}
	
	static boolean haveAcquaintance(int[] M, int index){
		if(M[index] == 1)
			return true;
		else
			return false;
	}
}
