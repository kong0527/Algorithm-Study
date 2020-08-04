import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_2667 {
	static int arr[][];
	static int visited[][];
	static int YES = 1;
	static int NO = -1;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		arr= new int[num][num];
		visited = new int[num][num];
		
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for (int i = 0; i < num; i++) {
			String s = br.readLine();
			for (int j = 0; j < num; j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				visited[i][j] = NO;
			}
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (arr[i][j] == 1 && visited[i][j] == NO) {
					visited[i][j] = YES;
					ans.add(bfs(i, j, num));
				}
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	
	}
	
	public static int bfs(int x, int y, int num) {
		Queue<Location> queue = new LinkedList<Location>();
		int count = 1;
		Location loc;
		queue.add(new Location(x, y));
		
		while (!queue.isEmpty()) {
			loc = queue.poll();
			int bx = loc.x;
			int by = loc.y;
			
			if (bx >= num || by >= num || bx < 0 || by < 0) {
				break;
			}
			
			//위로 올라가는 경우
			if (bx-1 >= 0 && arr[bx-1][by] == 1 && visited[bx-1][by] == NO) {
				queue.add(new Location(bx-1, by));
				visited[bx-1][by] = YES;
				count++;
			}
			
			//아래로 올라가는 경우
			if (bx+1 < num && arr[bx+1][by] == 1 && visited[bx+1][by] == NO) {
				queue.add(new Location(bx+1, by));
				visited[bx+1][by] = YES;
				count++;
			}
			
			//왼쪽으로 가는 경우
			if (by-1 >= 0 && arr[bx][by-1] == 1 && visited[bx][by-1] == NO) {
				queue.add(new Location(bx, by-1));
				visited[bx][by-1] = YES;
				count++;
			}
			
			//오른쪽으로 가는 경우
			if (by+1 < num && arr[bx][by+1] == 1 && visited[bx][by+1] == NO) {
				queue.add(new Location(bx, by+1));
				visited[bx][by+1] = YES;
				count++;
			}
		}
		return count;
	}
}
