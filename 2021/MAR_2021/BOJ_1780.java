import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        arr = new int[size][size];
        // -1, 0, 1의 갯수를 셀 배열
        answer = new int[3];

        // size가 1이라면 그 수 하나의 갯수만 센다.
        if (size == 1) {
            int num = Integer.parseInt(br.readLine());
            answer[num+1] = 1;
        }

        // 아니라면 arr에 숫자들을 저장한다.
        else {
            for (int i = 0; i < size; i++) {
                String st[] = br.readLine().split(" ");
                for (int j = 0; j < size; j++) {
                    arr[i][j] = Integer.parseInt(st[j]);
                }
            }
        }

        // 시작점 0,0으로 재귀함수 호출
        recursion(0, 0, size);

        // answer 배열을 출력한다.
        for (int n : answer) {
            System.out.println(n);
        }
    }

    public static void recursion(int x, int y, int size) {
        // 한 구역 내에 모두 같은 수가 있으면 그 수의 개수를 1 증가시킨다.
        if (isSame(x, y, size)) {
            answer[arr[x][y]+1] += 1;
        }

        // 그렇지 않다면 9구역으로 나눠 다시 재귀를 한다.
        else {
            int num = size / 3;
            for (int i = x; i < x+size; i += num) {
                for (int j = y; j < y+size; j += num) {
                    recursion(i, j,num);
                }
            }
        }
    }

    // 해당 구역이 모두 같은 숫자로 이루어져 있는지 판별하는 함수
    public static boolean isSame(int x, int y, int size) {
        boolean flag = true;
        int prev = arr[x][y];

        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (i == x && j == y) {
                    continue;
                }
                if (prev != arr[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        return flag;
    }
}
