import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine());
		long sum = 0;
		int count = 0;
		
		for (long i = 1; ; i++) {
			if (sum > num) {
				break;
			}
			sum += i;
			count++;
		}
		System.out.println(--count);
	}

}
