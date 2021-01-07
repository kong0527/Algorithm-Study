import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4796 {
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        count = 1;
        while (true) {
            String st[] = br.readLine().split(" ");
            int possible = Integer.parseInt(st[0]);
            int camping = Integer.parseInt(st[1]);
            int vacation = Integer.parseInt(st[2]);
            if (possible == 0 && camping == 0 && vacation == 0) {
                break;
            }
            solve(possible, camping, vacation);
        }
    }
    public static void solve(int possible, int camping, int vacation) {
        int q = vacation / camping * possible;
        int r = Math.min(vacation % camping, possible);
        int ans = q + r;


        System.out.println("Case " + count++ +": " + ans);
    }
}
