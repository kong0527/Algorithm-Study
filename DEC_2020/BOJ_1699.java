import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1699 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(solve(num));
	}

	public static int solve(int num) {
		int dp[] = new int[num+1];
		dp[0] = 0;	dp[1] = 1;
		for (int i = 2; i <= num; i++) {
			dp[i] = i;
			for (int j = 2; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j*j] + 1);
			}
		}
		
		return dp[num];
	}
	
}
