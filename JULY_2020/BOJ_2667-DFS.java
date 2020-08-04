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
					ans.add(dfs(i, j, num));
				}
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	
	}
	
	public static int dfs(int x, int y, int num) {
		int count = 1;
		visited[x][y] = YES;
		
		if (x < num || y < num || y >= 0 || y >= 0) {
			//위로 올라가는 경우
			if (x-1 >= 0 && arr[x-1][y] == 1 && visited[x-1][y] == NO) {
				count += dfs(x-1,y, num);
			}
			
			//아래로 올라가는 경우
			if (x+1 < num && arr[x+1][y] == 1 && visited[x+1][y] == NO) {
				count += dfs(x+1,y, num);
			}
			
			//왼쪽으로 가는 경우
			if (y-1 >= 0 && arr[x][y-1] == 1 && visited[x][y-1] == NO) {
				count += dfs(x,y-1, num);
			}
			
			//오른쪽으로 가는 경우
			if (y+1 < num && arr[x][y+1] == 1 && visited[x][y+1] == NO) {
				count += dfs(x,y+1, num);
			}
		}
		
		return count;
	}
}
