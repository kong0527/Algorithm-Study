import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		System.out.println(solve(num));
	}
	
	public static long solve(int num) {
		long dp[][] = new long[num+1][10];
		long sum = 0;
		
		for (int i = 1; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= num; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 0) {
					dp[i][j] = dp[i-1][j+1] % 1000000000;
				}
				else if(j == 9){
					dp[i][j] = dp[i-1][j-1] % 1000000000;
				}
				else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
				}
			}
		}
		
		for (int i = 0; i <= 9; i++) {
			sum += dp[num][i];
		}
		
		return sum % 1000000000;
	}
}