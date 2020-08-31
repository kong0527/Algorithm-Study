import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15649 {
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		arr = new int[n];
		visited = new boolean[n];
		
		solve(n, m, 0);

	}
	
	public static void solve(int n, int m, int d) {
		if (d == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[d] = i + 1;
				solve(n, m, d+1);
				visited[i] = false;
			}
		}
	}
}
