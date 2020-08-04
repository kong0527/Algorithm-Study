import java.util.Scanner;

public class BOJ_2579 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int arr[] = new int[num+1];
		arr[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		
		System.out.println(solve(arr));

	}
	
	public static int solve(int[] arr) {
		int dp[] = new int[arr.length];
		dp[1] = arr[1];
		if (arr.length >= 3)
			dp[2] = arr[2] + arr[1];
		
		for (int i = 3; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-3] + arr[i-1] + arr[i], dp[i-2] + arr[i]);
		}
		return dp[dp.length-1];	
	}
}
