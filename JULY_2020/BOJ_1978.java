import java.util.*;

public class BOJ_1978 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		// TODO Auto-generated method stub
		
		int num = input.nextInt();
		int [] arr = new int[num];
		int count = 0;
		int flag = -1;
		
		for (int i = 0; i < num; i++) {
			arr[i] = input.nextInt();
		}
		
		for (int i = 0; i < num; i++) {
			for (int n = 2; n <= arr[i]; n++) {
				if (arr[i] == 1)
					break;
				else if (arr[i] == 2) 
					flag = 1;
				else if (arr[i] % n == 0)
					break;
				else if (n == arr[i]-1)
					flag = 1;
			}
			if (flag == 1) {
				count++;
				flag = -1;
			}
		}
		
		System.out.print(count);
	}

}
