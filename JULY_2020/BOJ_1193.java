import java.util.*;

public class BOJ_1193 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int num = input.nextInt();
		int sum = 0;
		int x = 0;
		int y = 0;
		int diff = 0;
		int line = 1;
		
		while (sum < num) {
			sum = line * (line+1) / 2;
			line++;
		}
		
		diff = sum - num;
		x = 1 + diff;
		y = line - diff - 1;
		
		if (line % 2 == 0)
			System.out.print(x +"/"+ y);
		else
			System.out.print(y + "/" + x);
	}
}

