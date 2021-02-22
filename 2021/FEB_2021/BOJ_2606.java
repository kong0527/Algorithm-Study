import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    static int computers[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        computers = new int[size+1][size+1];
        visited = new boolean[size+1];

        for (int i = 0; i < num; i++) {
            String st[] = br.readLine().split(" ");
            int x = Integer.parseInt(st[0]);
            int y = Integer.parseInt(st[1]);
            computers[x][y] = 1;
            computers[y][x] = 1;
        }

        dfs(1);
        System.out.println(count);
    }

    public static void dfs(int idx) {
        visited[idx] = true;

        for (int i = 1; i < computers[0].length; i++) {
            if (!visited[i] && computers[idx][i] == 1) {
                dfs(i);
                count++;
            }
        }
    }
}
