import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int[][] arr = new int[num][3];
		
		for (int i = 0; i < num; i++)
			for (int j = 0; j < 3; j++)
				arr[i][j] = input.nextInt();
		
		System.out.println(Math.min(Math.min(sol3(arr, arr.length-1, 0), sol3(arr, arr.length-1, 1)), sol3(arr, arr.length-1, 2)));
	}
	
	//Àç±Í
	public static int sol(int[][] arr, int i, int j) {
		if (i == 0)
			return arr[i][j];
		
		else if (j == 0)
			return Math.min(sol(arr, i-1, 1), sol(arr, i-1, 2)) + arr[i][j];
		
		else if (j == 1)
			return Math.min(sol(arr, i-1, 0), sol(arr, i-1, 2)) + arr[i][j];
		
		else 
			return Math.min(sol(arr, i-1, 0), sol(arr, i-1, 1)) + arr[i][j];
		}
	
	//memoization
	public static int sol2(int[][] arr, int i, int j) {
		int [][] memo = new int[arr.length][3];
		
		for (int m = 0; m < arr.length; m++)
			for (int n = 0; n < 3; n++)
				memo[m][n] = -1;
		
		if (memo[i][j] != -1)
			return memo[i][j];
		
		if (i == 0)
			memo[i][j] = arr[i][j];
		
		else if (j == 0)
			memo[i][j] = arr[i][j] + Math.min(sol2(arr, i-1, 1), sol2(arr, i-1, 2));
		
		else if (j == 1)
			memo[i][j] = arr[i][j] + Math.min(sol2(arr, i-1, 0), sol2(arr, i-1, 2));
		
		else 
			memo[i][j] = arr[i][j] + Math.min(sol2(arr, i-1, 0), sol2(arr, i-1, 1));
		
		return memo[i][j];
	}
	
	// dp (Á¤´ä)
	public static int sol3(int[][] arr, int m, int n) {
		int [][] L = new int[arr.length][3];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 0)
					L[i][j] = arr[i][j];
				
				else if (j == 0)
					L[i][j] = arr[i][j] + Math.min(L[i-1][1], L[i-1][2]);
				
				else if (j == 1)
					L[i][j] = arr[i][j] + Math.min(L[i-1][0], L[i-1][2]);
				
				else
					L[i][j] = arr[i][j] + Math.min(L[i-1][0], L[i-1][1]);
			}
		}
		return L[m][n];
	}
}
