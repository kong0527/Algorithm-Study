import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int arr[][];
    static boolean visited[][];
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testNum = Integer.parseInt(br.readLine());
        int ans[] = new int[testNum];

        for (int i = 0; i < testNum; i++) {
            String st[] = br.readLine().split(" ");
            M = Integer.parseInt(st[0]);
            N = Integer.parseInt(st[1]);
            arr = new int[N][M];
            visited = new boolean[N][M];
            for (int j = 0; j < Integer.parseInt(st[2]); j++) {
                String loc[] = br.readLine().split(" ");
                arr[Integer.parseInt(loc[1])][Integer.parseInt(loc[0])] = 1;
            }
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (arr[x][y] == 1 && !visited[x][y]) {
                        visited[x][y] = true;
                        bfs(x, y);
                        ans[i] += 1;
                    }
                }
            }

        }

        for (int n : ans) {
            System.out.println(n);
        }

    }

    public static void bfs(int x, int y) {
        Queue<Location> queue = new LinkedList<Location>();
        Location loc;
        queue.add(new Location(x, y));

        while (!queue.isEmpty()) {
            loc = queue.poll();
            int bx = loc.x;
            int by = loc.y;

            if (bx >= N || by >= M || bx < 0 || by < 0) {
                break;
            }

            //위로 올라가는 경우
            if (bx-1 >= 0 && arr[bx-1][by] == 1 && !visited[bx-1][by]) {
                queue.add(new Location(bx-1, by));
                visited[bx-1][by] = true;
            }

            //아래로 내려가는 경우
            if (bx+1 < N && arr[bx+1][by] == 1 && !visited[bx+1][by]) {
                queue.add(new Location(bx+1, by));
                visited[bx+1][by] = true;
            }

            //왼쪽으로 가는 경우
            if (by-1 >= 0 && arr[bx][by-1] == 1 && !visited[bx][by-1]) {
                queue.add(new Location(bx, by-1));
                visited[bx][by-1] = true;
            }

            //오른쪽으로 가는 경우
            if (by+1 < M && arr[bx][by+1] == 1 && !visited[bx][by+1]) {
                queue.add(new Location(bx, by+1));
                visited[bx][by+1] = true;
            }
        }
    }

    static class Location {
        int x, y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
