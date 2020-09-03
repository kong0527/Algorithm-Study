import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15953 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int arr[][] = new int[num][2];
		
		for (int i = 0; i < num; i++) {
			String s[] = br.readLine().split(" ");
			for(int j = 0; j < 2; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		solve(arr, num);
	}
	
	public static void solve(int arr[][], int num) {
		int ans[] = new int[num];
		int cf2017[][] = {{5000000, 1}, {3000000,2}, {2000000, 3}, {500000, 4}, {300000, 5}, {100000, 6}};
		int cf2018[][] = {{5120000, 1}, {2560000, 2}, {1280000, 4}, {640000, 8}, {320000, 16}};
		
		for (int i = 0; i < num; i++) {
			for (int j = 0; j < 2; j++) {
				int rank = 0;
				if (j == 0) {
					if (arr[i][j] > 21 || arr[i][j] == 0) {
						ans[i] += 0;
					}
					
					else {
						int k = 0;
						while (rank < arr[i][j]) {
							rank += cf2017[k++][1]; 
						}
						k--;
						ans[i] += cf2017[k][0];
					}
				}
				
				else {
					if (arr[i][j] > 31 || arr[i][j] == 0) {
						ans[i] += 0;
					}
					
					else {
						int k = 0;
						while (rank < arr[i][j]) {
							rank += cf2018[k++][1]; 
						}
						k--;
						ans[i] += cf2018[k][0];
					}
				}
			}
		}
		
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}
}
