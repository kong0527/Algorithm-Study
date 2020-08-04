import java.util.*;

public class BOJ_9461 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		int[] arr = new int[num];
		
		for (int i = 0; i < num; i++)
			arr[i] = input.nextInt();
		
		for (int i = 0; i < num; i++)
			System.out.println(padovan(arr[i]));
	}
	
	public static long padovan(int n) {
		if (n == 1 || n == 2 || n == 3)
			return 1;
		
		else if (n == 4 || n == 5)
			return 2;
		
		else {
			long pad[] = new long[n+1];
			pad[1] = pad[2] = pad[3] = 1;
			pad[4] = pad[5] = 2;
			
			for (int i = 6; i <= n; i++) {
				pad[i] = pad[i-5] + pad[i-1];
			}			
			return pad[n];
		}
	}
}