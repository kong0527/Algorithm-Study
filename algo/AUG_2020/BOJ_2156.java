import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2156 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int arr[] = new int[num];
        
        for(int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(solve(arr));
	}
	
	public static int solve(int[] arr) {			
		if (arr.length == 1) {
			return arr[0];
		}
		
		else if (arr.length == 2) {
			return arr[0] + arr[1];
		}
		
		else {
			int dp[] = new int[arr.length];
			dp[0] = arr[0];	dp[1] = arr[0] + arr[1];
			dp[2] = Math.max(dp[1], Math.max(arr[0]+arr[2], arr[1]+arr[2]));
			
			for (int i = 3; i < dp.length; i++) {
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]));
			}
			return dp[dp.length-1];
		}
	}
}
