import java.util.Scanner;

public class BOJ_1463 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		System.out.println(solve(num));
		System.out.println(solve2(num));

	}

	public static int solve(int num) {
		int[] arr = new int[num+1];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	
		for (int i = 2; i <= num; i++) {
			arr[i] = arr[i-1] + 1;
			if (i % 2 == 0)
				arr[i] = Math.min(arr[i/2]+1, arr[i]);
			
			if (i % 3 == 0)
				arr[i] = Math.min(arr[i/3]+1, arr[i]);
			
			//값 확인용
			//System.out.println("arr[" + i + "] = " + arr[i]);
		}

		return arr[num];
	}
	
	public static int solve2(int num) {
		int[] arr = new int[num+1];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		
		for (int i = 2; i <= num; i++) {
			if (i % 6 == 0) {
				arr[i] = 1 + Math.min(arr[i/3], arr[i/2]);
			}

			else if (i % 2 == 0 && i % 3 == 1) {
				arr[i] = 1 + Math.min(arr[i/2], arr[i-1]);
			}

			else if (i % 3 == 0) {
				arr[i] = 1 + arr[i/3];
			}

			else if (i % 2 == 0) {
				arr[i] = 1 + arr[i/2];
			}

			else {
				arr[i] = 1 + arr[i-1];
			}

			//System.out.println("arr[" + i + "] = " + arr[i]);
		}
		
		return arr[num];
	}
}
