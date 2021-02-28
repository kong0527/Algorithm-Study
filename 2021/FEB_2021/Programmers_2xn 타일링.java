class Solution {
    public int solution(int n) {
        int dp[] = new int[n+1];

        if (n == 1) {
            return 1;
        }

        else if (n == 2) {
            return 2;
        }

        else {
            // dp의 초기값 설정
            dp[1] = 1; dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                // dp를 쌓아나가는 과정은 아래와 같다.
                // 하나 이전의 값에 1x2 타일을 붙이는 경우 + 두 개 이전의 값에 2x1 타일을 붙이는 경우
                dp[i] = dp[i-1] % 1000000007 + dp[i-2] % 1000000007;
            }
        }

        return dp[n] % 1000000007;
    }
}