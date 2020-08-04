import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num];

        for (int i = 0; i < arr.length; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 0; i < arr.length; i++) {
        	System.out.println(solve(arr[i]));
        }
	}
	
	public static int solve(int num) {
		if (num == 1)
			return 1;
		
		else if (num == 2)
			return 2;
		
		else if (num == 3)
			return 4;
		
		else {
			int dp[] = new int[num+1];
			dp[1] = 1;	dp[2] = 2;	dp[3] = 4;
			for (int i = 4; i < dp.length; i++) {
				dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
			}
			
			return dp[num];
		}
	}
}
