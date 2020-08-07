import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1697 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int sub = Integer.parseInt(s[0]);
		int sis = Integer.parseInt(s[1]);
		
		if (sub >= sis) {
			System.out.println(sub - sis);
		}
		
		else {
			System.out.println(solve(sub, sis));
		}
	}
	
	public static int solve(int sub, int sis) {
		int visited[] = new int[100001];
		Arrays.fill(visited, -1);
		Queue<Integer> queue = new LinkedList<>();
		queue.add(sub);
		visited[sub] = 0;
		
		while (!queue.isEmpty()) {
			int loc = queue.poll();
			
			if (loc < 0 || loc > 100000) {
				break;
			}
			
			if (loc-1 >= 0 && visited[loc-1] == -1) {
				queue.add(loc-1);
				visited[loc-1] = visited[loc]+1;
			}
			
			if (loc+1 <= 100000 && visited[loc+1] == -1) {
				queue.add(loc+1);
				visited[loc+1] = visited[loc]+1;
			}
			
			if (loc*2 <= 100000 && visited[loc*2] == -1) {
				queue.add(loc*2);
				visited[loc*2] = visited[loc]+1;
			}
		}
	
		return visited[sis];
	}
}
