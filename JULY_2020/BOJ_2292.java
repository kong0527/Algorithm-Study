import java.util.*;
public class BOJ_2292 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		int sum = 1;
		int x = 0;
		
		while (true) {
			sum += 6*x;
			if (sum >=num)
				break;
			x++;
		}
		System.out.println(x+1);
	}
}
