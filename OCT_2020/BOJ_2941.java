import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2941 {
	static String[] letters = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		System.out.println(solve(s));
	}
	
	public static int solve(String s) {
		for (int i = 0; i < letters.length; i++) {
			if (s.contains(letters[i])) {
				s = s.replaceAll(letters[i], "_");
			}
		}
		
		return s.length();
	}
}
