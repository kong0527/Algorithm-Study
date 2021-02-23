import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int arr[][];
    static boolean visited[][];
    static int m;
    static int n;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        boolean flag = false;
        m = Integer.parseInt(st[0]);
        n = Integer.parseInt(st[1]);
        arr = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visited[0][i] && arr[0][i] == 0) {
                dfs(0, i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (visited[m-1][i]) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int bx = x + dx[i];
            int by = y + dy[i];

            if (bx >= 0 && by >= 0 && bx < m && by < n) {
                if (arr[bx][by] == 0 && !visited[bx][by]) {
                    dfs(bx, by);
                }
            }
        }
    }
}
