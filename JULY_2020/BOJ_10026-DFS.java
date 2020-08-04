import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Location {
	int x, y;
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_10026 {
	static char arr[][];
	static int visited[][];
	static int num;
	static int YES = 1;
	static int NO = -1;
	static int nCount = 0;
	static int abCount = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		num = Integer.parseInt(br.readLine());
		arr = new char[num][num];
		visited = new int[num][num];
		
		for (int i = 0; i < num; i++) {
			String s = br.readLine();
			for (int j = 0; j < num; j++) {
				arr[i][j] = s.charAt(j);
				visited[i][j] = NO;
			}
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (visited[i][j] == NO) {
					visited[i][j] = YES;
					dfs(i, j, arr[i][j]);
					nCount++;
				}
			}
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				visited[i][j] = NO;
				if (arr[i][j] == 'R') {
					arr[i][j] = 'G';
				}
			}
		}
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < num; j++) {
				if (visited[i][j] == NO) {
					visited[i][j] = YES;
					dfs(i, j, arr[i][j]);
					abCount++;
				}
			}
		}
		
		System.out.println(nCount + " " + abCount);
	}
	
	public static void dfs(int x, int y, char color) {
		visited[x][y] = YES;
		
		if (x < num || y < num || y >= 0 || y >= 0) {
			//위로 올라가는 경우
			if (x-1 >= 0 && arr[x-1][y] == color && visited[x-1][y] == NO) {
				dfs(x-1,y, arr[x-1][y]);
			}
			
			//아래로 올라가는 경우
			if (x+1 < num && arr[x+1][y] == color && visited[x+1][y] == NO) {
				 dfs(x+1,y, arr[x+1][y]);
			}
			
			//왼쪽으로 가는 경우
			if (y-1 >= 0 && arr[x][y-1] == color && visited[x][y-1] == NO) {
				dfs(x,y-1, arr[x][y-1]);
			}
			
			//오른쪽으로 가는 경우
			if (y+1 < num && arr[x][y+1] == color && visited[x][y+1] == NO) {
				dfs(x,y+1, arr[x][y+1]);
			}
		}
	}
}
