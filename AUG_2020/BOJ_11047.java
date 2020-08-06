import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_11047 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int num = Integer.parseInt(s[0]);
		int money = Integer.parseInt(s[1]);
		Integer arr[] = new Integer[num];
		
		for (int i = 0; i < arr.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 arr[i] = Integer.parseInt(st.nextToken());;
		}
		
		System.out.println(solve(arr, money));
	}
	
	public static int solve(Integer[] arr, int money) {
		Arrays.sort(arr, Collections.reverseOrder());
		int count = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (money == 0) {
				 break;
			}
			count += money / arr[i];
			money -= (money / arr[i]) * arr[i];
		}
	
		return count;
	}
}
