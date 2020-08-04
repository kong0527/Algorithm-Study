import java.util.*;
public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		int x = input.nextInt();
		int[][] arr = new int[x][3];
		
		for (int i = 0; i < x; i++) 
			for (int j = 0; j < 3; j++)
				arr[i][j] = input.nextInt();
		
		for (int i = 0; i < x; i++) {
			int h = arr[i][2] % arr[i][0];
			int w = arr[i][2] / arr[i][0];
			if (h == 0) 
				System.out.print(arr[i][0]);
			else {
				System.out.print(h);
				w++;
			}
			System.out.printf("%02d\n", w);
		}
	}
}
