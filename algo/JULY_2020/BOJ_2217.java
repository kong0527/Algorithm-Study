import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2217 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        Integer arr[] = new Integer[num];
        
        for(int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(solve(arr));
	}
	
	public static int solve(Integer[] arr) {
		Arrays.sort(arr, Collections.reverseOrder());
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i] * (i+1))
				max = arr[i] * (i+1);
		}
		return max;
	}

}
