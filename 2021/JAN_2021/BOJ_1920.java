import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int exist[] = new int[Integer.parseInt(br.readLine())];
        String st[] = br.readLine().split(" ");
        for (int i = 0; i < exist.length; i++) {
            exist[i] = Integer.parseInt(st[i]);
        }
        Arrays.sort(exist);

        int num = Integer.parseInt(br.readLine());
        st = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            solve(exist, Integer.parseInt(st[i]));
        }
    }

    public static void solve(int exist[], int num) {
        int idx = Arrays.binarySearch(exist, num);
        if (idx < 0) {
            System.out.println("0");
        }
        else {
            System.out.println("1");
        }
    }
}
