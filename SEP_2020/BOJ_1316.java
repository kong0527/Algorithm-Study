import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < num; i++) {
			String st = br.readLine();
			ans += solve(st);
		}
		
		System.out.println(ans);
	}
	
	public static int solve(String st) {
		char[] check = new char[st.length()];
		Arrays.fill(check, '0');
		
		for (int i = 0; i < check.length; i++) {
			if (i != check.length-1 && st.charAt(i) == st.charAt(i+1)) {
				continue;
			}
			else {
				check[i] = st.charAt(i);
			}
		}
		
		
		for (int i = 0; i < check.length; i++) {
			for (int j = i+1; j < check.length; j++) {
				if (check[j] == '0') {
					continue;
				}
				
				else {
					if (check[i] == check[j]) {
						return 0;
					}
				}
			}
		}
		
		return 1;
	}
}
