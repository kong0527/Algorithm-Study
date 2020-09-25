import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15652 {
	public static int[] arr;
	public static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		arr = new int[M];
		solve(1, 0);
	}
	
	public static void solve(int start, int depth) {
		if (depth == M) {
			for (int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println();
			return ;
		}
		
		for (int i = start; i <= N; i++) {
			arr[depth] = i;
			solve(i, depth + 1);
		}		
	}

}
