import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(solve(num));
	}

	public static int solve(int num) {
		int change = 1000 - num;
		int count = 0;
		int chArr[] = {500, 100, 50, 10, 5, 1};
		for (int i = 0; i < chArr.length; i++) {
			if (change == 0) {
				break;
			}
			int mod = change / chArr[i];
			change -= mod * chArr[i];
			count += mod;			
		}
		
		return count;
	}
}
