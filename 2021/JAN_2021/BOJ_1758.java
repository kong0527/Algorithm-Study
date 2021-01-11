import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_1758 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Integer arr[] = new Integer[num];

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(arr));
    }

    public static long solve(Integer arr[]) {
        Arrays.sort(arr, Collections.reverseOrder());
        long ans = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - i < 0) {
                break;
            }

            ans += arr[i] - i;
        }

        return ans;
    }
}
