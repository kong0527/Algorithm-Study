import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int arr[];
    static int total;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int num = Integer.parseInt(st[0]);
        total = Integer.parseInt(st[1]);
        arr = new int[num];
        st = br.readLine().split(" ");
        // 입력받은 수를 배열에 저장
        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }

        dfs(0,0);

        // 0을 만들어야 할 때, 아무것도 뽑지 않은 경우도 포함되므로 1을 빼준다.
        if (total == 0) {
            answer--;
        }
        System.out.println(answer);
    }

    public static void dfs(int idx, int sum) {
        // 끝까지 dfs를 했다면 total과 값이 같으면 answer++ 후 종료.
        if (idx == arr.length) {
            if (sum == total) {
                answer++;
            }
            return ;
        }

        // 현재 수를 뽑지 않는 경우
        dfs(idx + 1, sum + arr[idx]);
        // 현재 수를 뽑는 경
        dfs(idx + 1, sum);
    }
}
