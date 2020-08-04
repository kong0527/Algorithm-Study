import java.util.*;

public class BOJ_2518 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		int x = input.nextInt();
		int y = input.nextInt();
		int sum = 0;
		int min = 999999;

		for (int i = x; i <= y; i++) {
			for (int n = 2; n <= i; n++) {
				if (i == 1)
					break;
				else if (i == 2) {
					sum += i;
					if (min > i)
						min = i;
				}
				else if (i % n == 0)
					break;
				else if (n == i - 1) {
					sum += i;
					if (min > i)
						min = i;
				}
			}
		}

		if (sum == 0)
			System.out.println("-1");
		
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
