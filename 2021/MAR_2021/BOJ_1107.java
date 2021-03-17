import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        int num = Integer.parseInt(br.readLine());
        int broken[] = new int[10];

        // 고장난 리모컨이 없다면 아예 입력을 받지 않음
        if (num != 0) {
            String st[] = br.readLine().split(" ");
            for (int i = 0; i < num; i++) {
                broken[Integer.parseInt(st[i])] = -1;
            }
        }

        System.out.println(solve(target, broken));
    }

    public static int solve(String target, int[] broken) {
        // 현재 채널이 100이므로 target이 100이라면 바로 0을 반환
        if (target.equals("100")) {
            return 0;
        }

        // 모든 번호가 고장났는지 판별하기 위한 변수
        boolean flag = true;

        for (int i = 0; i < broken.length; i++) {
            // 고장나지 않은 번호가 있다면 flag를 false로
            if (broken[i] == 0) {
                flag = false;
                break;
            }
        }

        // +, - 만으로 움직이는 경우
        int min = Math.abs(Integer.parseInt(target) - 100);

        // 모든 번호가 고장났다면 +, -를 이용하는 방법밖에 없으므로 100과 target의 차이를 구한다.
        if (flag) {
            return min;
        }

        for (int i = 0; i < 1000000; i++) {
            // i가 만들어질 수 있는 채널 번호인지 판별하기 위한 변수
            flag = true;
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                // 채널 i에 들어있는 번호 중 고장난 번호가 있다면 flag를 false
                int num = s.charAt(j) - '0';
                if (broken[num] == -1) {
                    flag = false;
                    break;
                }
            }
            // 채널 i를 만들 수 있는 경우라면
            if (flag) {
                // target에서 i까지 +, - 로 움직인 횟수 + 숫자 i의 길이
                int count = Math.abs(Integer.parseInt(target) - i) + String.valueOf(i).length();
                // 현재까지의 최솟값과 위에서 구한 값을 비교한다.
                min = Math.min(count, min);
            }
        }

        return min;
    }
}
