import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10773 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[] = new int[num];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(solve(arr));
	}
	
	public static int solve (int arr[]) {
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (i != 0 && arr[i] == 0) {
				int idx = i-1;
				while (arr[idx] == 0) {
					idx--;
				}
				arr[idx] = 0;
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		return sum;
	}
}
