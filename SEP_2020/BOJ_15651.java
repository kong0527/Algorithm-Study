import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_15651 {
	public static int[] arr;
	public static int N, M;
	public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		arr = new int[M];
		
		solve(0);
		br.close();
		bw.flush();
		bw.close();
	}

	public static void solve(int depth) throws IOException {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				bw.write(String.valueOf(arr[i]) + " ");
			}
			bw.newLine();
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			arr[depth] = i+1;
			solve(depth+1);
		}
	}
	
}
