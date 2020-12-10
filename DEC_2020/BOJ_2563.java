import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2563 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int count = 0;
		int arr[][] = new int[101][101];
		for (int i = 0; i < num; i++) {
			String st[] = br.readLine().split(" ");
			int x = Integer.parseInt(st[0]);
			int y = Integer.parseInt(st[1]);
			for (int j = x; j < x+10; j++) {
				for (int z = y; z < y+10; z++) {
					if (arr[j][z] == 0) {
						arr[j][z] = 1;
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}

