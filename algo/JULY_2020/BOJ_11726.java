import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		System.out.println(solve(num));
		
	}
	
	public static int solve(int num) {	
		if (num == 1)
			return 1;
		
		else if (num == 2)
			return 2;
		
		else {
			int dp[] = new int[num+1];
			dp[1] = 1;	dp[2] = 2;
			
			for (int i = 3; i < dp.length; i++) {
				dp[i] = dp[i-2] + dp[i-1];
				dp[i] %= 10007;
			}
			
			return dp[num];
		}
	}

}
