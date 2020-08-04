import java.util.Scanner;
import java.util.Arrays;

public class BOJ_11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		int arr[] = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = input.nextInt();
		}
		
		System.out.println(solve(arr));
	}
	
	public static int solve(int[] arr) {	
		Arrays.sort(arr);
		int min = arr[0];
		
		for (int i = 1; i < arr.length; i++ ) {
			arr[i] = arr[i -1] + arr[i];
			min += arr[i];
		}
		
		return min;
	}

}
