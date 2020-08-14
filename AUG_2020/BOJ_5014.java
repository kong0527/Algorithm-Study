import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_5014 {
	static int top;
	static int current;
	static int startlink;
	static int up;
	static int down;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		top = Integer.parseInt(st[0]);
		current = Integer.parseInt(st[1]);
		startlink = Integer.parseInt(st[2]);
		up = Integer.parseInt(st[3]);
		down = Integer.parseInt(st[4]);
		
		bfs();
	}
	
	public static void bfs() {
		int visited[] = new int[top+1];
		Queue<Integer> queue = new LinkedList<>();
		
		Arrays.fill(visited, -1);
		visited[current] = 0;
		queue.add(current);
		
		while (!queue.isEmpty()) {
			int loc = queue.poll();
			
			if (loc <= 0 || loc > top || loc == startlink) {
				break;
			}
			
			if (loc-down > 0 && visited[loc-down] == -1) {
				queue.add(loc-down);
				visited[loc-down] = visited[loc] + 1;
			}
			
			if (loc+up <= top && visited[loc+up] == -1) {
				queue.add(loc+up);
				visited[loc+up] = visited[loc] + 1;
			}
		}
		
		if (visited[startlink] == -1) {
			System.out.println("use the stairs");
		}
		
		else {
			System.out.println(visited[startlink]);
		}
	}
}
