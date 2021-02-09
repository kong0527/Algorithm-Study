import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int num = Integer.parseInt(st[0]);
        int won = Integer.parseInt(st[1]);
        int arr[] = new int[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(arr, won));
    }

    public static int solve(int arr[], int won) {
        int dp[] = new int[won+1];
        dp[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= won; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }

        return dp[won];
    }
}
