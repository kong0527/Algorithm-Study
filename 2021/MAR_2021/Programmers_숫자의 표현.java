class Solution {
    public int solution(int n) {
        // 자기 자신으로 표현할 수 있는 경우의 수를 미리 포함해준다.
        int answer = 1;
        // 연속된 숫자의 합의 값을 저장해 나갈 변수
        int sum = 1;

        // i는 시작 값, j는 i 이후에 연속된 값
        for (int i = 1; i <= n/2; i++) {
            for (int j = i+1; j <= n/2 + 1; j++) {
                // sum 값에 j를 더한다.
                sum += j;
                // sum과 n이 같으면 answer을 증가시켜주고 for문을 빠져나온다.
                if (sum == n) {
                    answer++;
                    break;
                }

                // sum이 더 크다면 값을 만들기에 실패한 것이므로 역시 for문을 빠져나온다.
                else if (sum > n) {
                    break;
                }
            }
            // sum값을 초기화해준다. (다음 시작 값을 미리 더해놓는다.)
            sum = i+1;
        }

        return answer;
    }
}