import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2309 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int arr[] = new int[9];
		 
		 for (int i = 0; i < arr.length; i++) {
			 arr[i] = Integer.parseInt(br.readLine());
		 }
		 
		 Arrays.sort(arr);
		 solve(arr);
	}
	
	public static void solve(int[] arr) {
		boolean flag = false;
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (flag) {
				break;
			}
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					continue;
				}
				
				if (sum - arr[i] - arr[j] == 100) {
					arr[i] = -1;
					arr[j] = -1;
					flag = true;
					break;
				}
				
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1) {
				System.out.println(arr[i]);
			}
		}
		
	}


}
