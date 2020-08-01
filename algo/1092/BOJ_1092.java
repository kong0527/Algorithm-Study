import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1092 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
        		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
        		Integer cranes[] = new Integer[num];
        		StringTokenizer st = new StringTokenizer(br.readLine());
        
       		for (int i = 0; i < cranes.length; i++) {
        			cranes[i] = Integer.parseInt(st.nextToken());
        		}
        
        		num = Integer.parseInt(br.readLine());
        		Integer boxes[] = new Integer[num];
        		st = new StringTokenizer(br.readLine());
        
        		for (int i = 0; i < boxes.length; i++) {
        			boxes[i] = Integer.parseInt(st.nextToken());
       		}
		
		/*Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		Integer cranes[] = new Integer[num];
		for (int i = 0; i < cranes.length; i++) {
			cranes[i] = input.nextInt();
		}
		num = input.nextInt();
		Integer boxes[] = new Integer[num];
		for (int i = 0; i < boxes.length; i++) {
			boxes[i] = input.nextInt();
		}*/
		
		System.out.println(solve(cranes, boxes));
	}
	
	public static int solve(Integer[] cranes, Integer[] boxes) {
		int count = 0;
		Arrays.sort(cranes, Collections.reverseOrder());
		Arrays.sort(boxes, Collections.reverseOrder());
		
		if (cranes[0] < boxes[0])
			return -1;
		
		else {
			while (boxes.length > 0) {
				int idx = 0;
				for (int i = 0; i < boxes.length; i++) {
					if (idx == cranes.length) {
						break;
					}
					
					if (cranes[idx] >= boxes[i]) {
						idx++;
						boxes = remove(boxes, i);
						i--;
					}
				}
				count++;
			}
		}
		
		return count;
	}
	
	public static Integer[] remove(Integer[] boxes, int idx) {
		Integer removed[] = new Integer[boxes.length-1];
		for (int i = 0, k = 0; i < boxes.length; i++) {
			if (i == idx) {
				continue;
			}
			removed[k++] = boxes[i];
		}
		return removed;
	}
}
