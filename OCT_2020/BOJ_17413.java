import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_17413 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stack = new Stack<Character>();
		boolean flag = false;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '<') {
				print(stack);
				flag = true;
				System.out.print(s.charAt(i));
			}
			
			else if (s.charAt(i) == '>') {
				flag = false;
				System.out.print(s.charAt(i));
			}
			
			else if (flag) {
				System.out.print(s.charAt(i));
			}
			
			else {
				if (s.charAt(i) == ' ') {
					print(stack);
					System.out.print(s.charAt(i));
				}
				
				else {
					stack.push(s.charAt(i));
				}
			}
		}
		
		print(stack);
	}
	
	public static void print (Stack stack) {
		while (!stack.empty()) {
			System.out.print(stack.peek());
			stack.pop();
		}
	}

}
