import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 들어온 순서대로 저장하는 큐
        Queue<String> in = new LinkedList<>();
        // 나간 순서대로 저장하는 큐
        Queue<String> out = new LinkedList<>();
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        // 들어온 순서대로 큐에 저장
        for (int i = 0; i < num; i++) {
            String car = br.readLine();
            in.add(car);
        }

        // 나간 순서대로 큐에 저장
        for (int i = 0; i < num; i++) {
            String car = br.readLine();
            out.add(car);
        }

        while (!in.isEmpty()) {
            // in과 out이 같으면 추월하지 않았으므로 그대로 큐에서 뺀다.
            if (in.peek().equals(out.peek())) {
                in.poll();
                out.poll();
            }
            // 다르면 count를 증가시키고 큐에서 추월한 차량을 뺀다.
            else {
                count++;
                in.remove(out.peek());
                out.poll();
            }
        }

        System.out.println(count);
    }

}
