import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String st[] = br.readLine().split(" ");
            // 골랐는지 표시할 visited 배열
            visited = new boolean[st.length];
            // while문 종료조건
            if (st[0].equals("0")) {
                break;
            }
            // combination 시작
            combination(st, visited, 1, st.length, 6);
            System.out.println();
        }
    }

    static void combination(String[] numbers, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            // 모두 골랐으면 print 호출
            print(numbers,visited, n);
            return;
        }

        // 백트래킹으로 조합의 경우의 수 구하기
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(numbers, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void print(String[] numbers, boolean[] visited, int n) {
        // 뽑힌 숫자들을 출력해준다.
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                if (i == n-1) {
                    System.out.print(numbers[i]);
                }
                else {
                    System.out.print(numbers[i] + " ");
                }
            }
        }
        System.out.println();
    }
}