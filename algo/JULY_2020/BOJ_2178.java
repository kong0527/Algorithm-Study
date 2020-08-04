import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_2178 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
        
        System.out.println(solve(N, M, arr));
	}
	
	public static int solve(int N, int M, int arr[][]) {
		int visited[][] = new int[N][M];
		Queue<Location> queue = new LinkedList<Location>();
		int YES = 1;
		int NO = -1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = NO;
			}
		}
		
		visited[0][0] = YES;
		queue.add(new Location(0,0));
		Location loc;
		
		while (!queue.isEmpty()) {
			loc = queue.poll();
			int x = loc.x;
			int y = loc.y;
			
			if (x == N-1 && y == M-1) {
				break;
			}
			
			//위로 올라가는 경우
			if (x-1 >= 0 && arr[x-1][y] == 1 && visited[x-1][y] == NO) {
				queue.add(new Location(x-1, y));
				visited[x-1][y] = YES;
				arr[x-1][y] = arr[x][y] + 1;
			}
			
			//아래로 올라가는 경우
			if (x+1 < N && arr[x+1][y] == 1 && visited[x+1][y] == NO) {
				queue.add(new Location(x+1, y));
				visited[x+1][y] = YES;
				arr[x+1][y] = arr[x][y] + 1;
			}
			
			//왼쪽으로 가는 경우
			if (y-1 >= 0 && arr[x][y-1] == 1 && visited[x][y-1] == NO) {
				queue.add(new Location(x, y-1));
				visited[x][y-1] = YES;
				arr[x][y-1] = arr[x][y] + 1;
			}
			
			//오른쪽으로 가는 경우
			if (y+1 < M && arr[x][y+1] == 1 && visited[x][y+1] == NO) {
				queue.add(new Location(x, y+1));
				visited[x][y+1] = YES;
				arr[x][y+1] = arr[x][y] + 1;
			}
		}
		return arr[N-1][M-1];
	}
}
