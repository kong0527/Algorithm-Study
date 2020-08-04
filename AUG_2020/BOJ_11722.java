import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11722 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num];
		String st[] = br.readLine().split(" ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}
		
		System.out.println(solve(arr));
	}
	
	public static int solve(int[] arr) {
		int dp[] = new int[arr.length];
		dp[0] = 1;
		
		for (int i = 1; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
				else if (arr[i] == arr[j]) {
					dp[i] = dp[j];
				}
			}
		}
		
		Arrays.sort(dp);
		return dp[dp.length-1];
	}

}
