import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(solve(num));
    }

    public static int solve(int num) {
        int min = 0;

        if (num % 5 == 0) {
            return num / 5;
        }

        if (num < 5 && num % 2 != 0) {
            return -1;
        }

        else {
            int tmp = num / 5;
            for (int i = 1; i <= tmp; i++) {
                int count = 0;
                int input = num;
                input -= i * 5;
                count += i;
                if (input % 2 != 0) {
                    continue;
                }
                else {
                    count += input / 2;
                }
                if (min == 0) {
                    min = count;
                }
                else {
                    min = Math.min(count, min);
                }
            }
        }

        if (min == 0) {
            return -1;
        }

        return min;
    }
}
