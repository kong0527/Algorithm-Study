import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String input = br.readLine();
	     String[] s = input.split("\\-");
	     int ans = calc(s[0]);
	     
	     for (int i = 1; i < s.length; i++) {
	    	 ans -= calc(s[i]);
	     }
	     
	     System.out.println(ans);
	}
	
	public static int calc(String s) {
		String[] st = s.split("\\+");
		int result = 0;
		
		for (int i = 0; i < st.length; i++) {
			result += Integer.parseInt(st[i]);
		}
		
		return result;
	}

}
