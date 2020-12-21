import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        solve(Long.parseLong(st[0]), Long.parseLong(st[1]));
    }

    public static void solve(long num, long length) {
        long limit = Math.round((double) num / 2);

        for (long i = limit; i >= 0; i--) {
            long sum = 0;
            long tmpStart = i;
            long tmpEnd = 0;
            for (long j = i; j > i - length; j--) {
                sum += j;
                tmpEnd = j;
            }

            if (sum == num && (tmpStart - tmpEnd + 1) >= length) {
                for (long x = tmpEnd; x <= tmpStart; x++) {
                    System.out.print(x + " ");
                }
                return ;
            }

            for (long k = i - length; k > 0; k--) {
                sum += k;
                tmpEnd = k;
                if ((tmpStart - tmpEnd + 1) > 100) {
                    break;
                }
                if (sum > num) {
                    break;
                }
                else if (sum == num) {
                    if ((tmpStart - tmpEnd + 1) >= length) {
                        for (long x = tmpEnd; x <= tmpStart; x--) {
                            System.out.print(x + " ");
                            return;
                        }
                    }
                }
            }
        }
    }
}
