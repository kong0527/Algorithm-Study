import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_11653 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		solve(num);
	}
	
	public static void solve(int num) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				num = num / i;
				ans.add(i);
				i = 1;
			}
		}
		
		for (Integer i : ans) {
			System.out.println(i);
		}
	}
}
