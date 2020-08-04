import java.util.Scanner;

public class BOJ_1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int arr[][] = new int[num+1][num+1];
		
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= i; j++) {
				arr[i][j] = input.nextInt();
			}
		}
		
		System.out.println(solve(arr));
	}
	
	public static int solve(int[][] arr) {
		int dp[][] = new int[arr.length][arr.length];
		int max = -1;
		dp[1][1] = arr[1][1];
		for (int i = 2; i < arr.length; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == 1)
					dp[i][j] = arr[i][j] + dp[i-1][j];
				else if (j == i)
					dp[i][j] = arr[i][j] + dp[i-1][j-1];
				else
					dp[i][j] = arr[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		
		for (int j = 1; j < dp.length; j++) {
			if (dp[dp.length-1][j] > max)
				max = dp[dp.length-1][j];
		}
		
		return max;
	}
	
	/*public static int solve(int[] arr, int num) {
		int dp[] = new int[num+1];
		dp[0] = 0;
		dp[1] = arr[1];
		int count = 1;
		
		for (int i = 1; count < num;) {
			dp[count+1] = dp[count] + Math.max(arr[i+count] + arr[i+count], arr[i+count+1]);
			if (arr[i+count] > arr[i+count+1]) {
				i = i+count;
			}
			else {
				i = i + count + 1;
			}
			
			count++;
		}
		
		return dp[num];
	}*/

}
