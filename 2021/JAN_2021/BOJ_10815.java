import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cardNum = Integer.parseInt(br.readLine());
        int cards[] = new int[cardNum];
        String st[] = br.readLine().split(" ");
        for (int i = 0; i < cardNum; i++) {
            cards[i] = Integer.parseInt(st[i]);
        }

        int checkNum = Integer.parseInt(br.readLine());
        int check[] = new int[checkNum];
        st = br.readLine().split(" ");
        for (int i = 0; i < checkNum; i++) {
            check[i] = Integer.parseInt(st[i]);
        }

        Arrays.sort(cards);
        int ans[] = new int[checkNum];

        for (int i = 0; i < checkNum; i++) {
            ans[i] = solve(check[i], cards);
        }

        for (int num : ans) {
            System.out.print(num + " ");
        }

    }

    public static int solve(int num, int cards[]) {
        int first = 0;
        int last = cards.length - 1;
        int mid = 0;

        while (first <= last) {
            mid = (first + last) / 2;
            if (num == cards[mid]) {
                return 1;
            }
            else  {
                if (num < cards[mid]) {
                    last = mid - 1;
                }
                else {
                    first = mid + 1;
                }
            }
        }
        return 0;
    }
}
