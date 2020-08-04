import java.util.*;

public class BOJ_10828 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner input = new Scanner(System.in);
      int top = -1;
      int maxSize = input.nextInt();
      int[] stackArr = new int[maxSize];
      String command;
      
   
      for (int i = 0; i < maxSize; i++) {
         command = input.next();
         if (command.equals("push")) {
            top++;
            stackArr[top] = input.nextInt();

         }
         else if (command.equals("pop")) {
            if (top == -1)
               System.out.println(-1);
            else {
               System.out.println(stackArr[top]);
               top--;
            }
         }
            
         else if (command.equals("size"))
            System.out.println(top + 1);

         else if (command.equals("empty")) {
            if (top == -1)
               System.out.println(1);
            else
               System.out.println(0);
         }

         else if (command.equals("top")) {
            if (top == -1)
               System.out.println(-1);
            else
               System.out.println(stackArr[top]);
         }
      }

   }
}