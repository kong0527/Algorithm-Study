import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(solve(num));
	}
	
	public static int solve (int num) {
		int dp[][] = new int[num+1][10];
		
		for (int j = 0; j < 10; j++) {
			dp[1][j] = 1;
		}
		
		for (int i = 2; i <= num; i++) {
			dp[i][0] = 1;
			for (int j = 1; j < 10; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
				dp[i][j] %= 10007;
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[num][i];
		}
		
		return sum % 10007;
	}
}
