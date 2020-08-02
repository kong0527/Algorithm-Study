import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2193 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(solve(num));

	}
	
	public static long solve(int num) {
		if (num == 1)
			return 1;
		
		else if (num == 2)
			return 1;
		
		else {
			long dp[] = new long[num+1];
			dp[1] = 1;	dp[2] = 1;
			
			for (int i = 3; i < dp.length; i++) {
				dp[i] = dp[i-1] + dp[i-2];
			}
			
			return dp[num];
		}
	}

}
