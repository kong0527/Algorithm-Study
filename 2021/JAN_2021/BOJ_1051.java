import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1051 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int N = Integer.parseInt(st[0]);
        int M = Integer.parseInt(st[1]);
        int arr[][] = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(solve(N, M, arr));
    }

    public static int solve(int N, int M, int[][] arr) {
        int area = 1;
        int length = 1;

        while (length <= N && length <= M) {
            for (int i = 0; i + length < N; i++) {
                for (int j = 0; j + length < M; j++) {
                    if (arr[i][j] == arr[i + length][j] && arr[i][j] == arr[i][j + length] && arr[i][j] == arr[i + length][j + length]) {
                        area = Math.max(area, (length+1) * (length+1));
                    }
                }
            }
            length++;
        }

        return area;
    }
}
