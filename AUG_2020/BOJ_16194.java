import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16194 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num+1];
		String st[] = br.readLine().split(" ");
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st[i-1]);
		}
		
		System.out.println(solve(arr));
	}
	
	public static int solve(int[] arr) {
		int dp[] = new int[arr.length];
		
		for (int i = 1; i < dp.length; i++) {
			dp[i] = arr[i];
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i-j] + arr[j]);
			}
		}
		
		return dp[dp.length-1];
	}

}
