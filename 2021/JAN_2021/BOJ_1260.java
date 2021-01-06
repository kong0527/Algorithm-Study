import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1260 {
    static int graph[][];
    static boolean visited[];
    static int vertex;
    static int edge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        vertex = Integer.parseInt(st[0]);
        edge = Integer.parseInt(st[1]);
        int start = Integer.parseInt(st[2]);
        graph = new int[vertex+1][vertex+1];
        visited = new boolean[vertex+1];

        for (int i = 0; i < edge; i++) {
            st = br.readLine().split(" ");
            int x = Integer.parseInt(st[0]);
            int y = Integer.parseInt(st[1]);
            graph[x][y] = graph[y][x] = 1;
        }

        dfs(start);
        System.out.println();
        visited = new boolean[vertex+1];
        bfs(start);

    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 1; i <= vertex; i++) {
            if (graph[start][i] == 1 && visited[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int out = queue.poll();
            System.out.print(out + " ");

            for (int i = 0; i <= vertex; i++) {
                if (graph[out][i] == 1 && visited[i] == false) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
