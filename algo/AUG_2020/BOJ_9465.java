import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int ans[] = new int[num];
		
		for (int k = 0; k < num; k++) {
			int size = Integer.parseInt(br.readLine());
			int arr[][] = new int[2][size+1];
			
			for (int  i = 0; i < 2; i++) {
				String[] st = br.readLine().split(" ");
				for (int j = 1; j <= size; j++) {
					arr[i][j] = Integer.parseInt(st[j-1]);
				}
			}
			ans[k] = solve(arr, size);
		}
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
	public static int solve(int[][] arr, int size) {
		int dp[][] = new int[2][size+1];
		dp[0][1] = arr[0][1];
		dp[1][1] = arr[1][1];
		
		for (int i = 2; i <= size; i++) {
			dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
			dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
		}
		
		return Math.max(dp[0][size], dp[1][size]);
	}

}
