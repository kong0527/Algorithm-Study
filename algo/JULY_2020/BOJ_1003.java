import java.util.*;
public class Main {
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner input = new Scanner(System.in);
      int num = input.nextInt();
      int[] arr = new int[num];

      for (int i = 0; i < arr.length; i++) {
         arr[i] = input.nextInt();
      }

      for (int i = 0; i < arr.length; i++) {
         countNum(arr[i]);
      }
   }

   public static void countNum(int n) {
      if (n == 0) {
    	  System.out.println(1 + " " + 0);
      }
      
      else if (n == 1) {
    	  System.out.println(0 + " " + 1);
      }
      
      else {
    	  int[][] sol = new int[n+1][2];
	      sol[0][0] = 1;
	      sol[0][1] = 0;
	      sol[1][0] = 0;
	      sol[1][1] = 1;
	      
	      for (int i = 2; i <= n; i++) {
	    	  sol[i][0] = sol[i-1][0] + sol[i-2][0];
	    	  sol[i][1] = sol[i-1][1] + sol[i-2][1];
	      }
	      System.out.println(sol[n][0] + " " + sol[n][1]);
      }
   }
}