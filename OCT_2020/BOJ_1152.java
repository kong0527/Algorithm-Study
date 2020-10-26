import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1152 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		if (st.trim().isEmpty()) {
			System.out.println(0);
		}
		else {
			String s[] = st.trim().split(" ");
			System.out.println(s.length);
		}
	}
}
