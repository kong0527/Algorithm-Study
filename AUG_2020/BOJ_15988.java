import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15988 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num+1];
		long ans[] = new long[num+1];

		for (int i = 1; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			ans[i] = solve(arr[i]);
		}
		
		for (int i = 1; i < arr.length; i++) {
			System.out.println(ans[i]);
		}
	}
	
	public static long solve(int num) {
		if (num == 1)
			return 1;
		
		else if (num == 2)
			return 2;
		
		else if (num == 3)
			return 4;
		
		else {
			long dp[] = new long[num+1];
			dp[1] = 1;	dp[2] = 2;	dp[3] = 4;
			
			for (int i = 4; i < dp.length; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
				dp[i] %= 1000000009;
			}
			return dp[num];
		}
	}
}
