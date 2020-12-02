import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		int earth = Integer.parseInt(st[0]);
		int sun = Integer.parseInt(st[1]);
		int moon = Integer.parseInt(st[2]);
		System.out.println(solve(earth, sun, moon));
	}

	public static int solve (int earth, int sun, int moon) {
		int e = 1;
		int s = 1;
		int m = 1;
		
		for (int i = 1; ; i++) {
			if (e == earth && s == sun && m == moon) {
				return i;
			}
			
			e++;
			s++;
			m++;
			
			if (e == 16) {
				e = 1;
			}
			
			if (s == 29) {
				s = 1;
			}
			
			if (m == 20) {
				m = 1;
			}
			
		}
	}
}
