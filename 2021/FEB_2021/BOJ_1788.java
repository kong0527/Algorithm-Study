import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        solve(num);
    }

    public static void solve(int num) {
        if (num == 0) {
            System.out.println(0);
            System.out.println(0);
            return ;
        }

        if (num == 1) {
            System.out.println(1);
            System.out.println(1);
            return ;
        }

        int tmp = Math.abs(num);
        int dp[] = new int[tmp+1];
        dp[0] = 0;  dp[1] = 1;
        for (int i = 2; i <= tmp; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
        }

        if (num > 0) {
            System.out.println(1);
        }

        else if (num < 0 && tmp % 2 == 0) {
            System.out.println(-1);
        }

        else if (num < 0) {
            System.out.println(1);
        }

        System.out.println(dp[tmp]);

    }
}
