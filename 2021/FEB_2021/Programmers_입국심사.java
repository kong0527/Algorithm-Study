import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right;
        long mid;
        long count = 0;

        Arrays.sort(times);
        right = n * (long) times[times.length-1];
        answer = right;

        while (left <= right) {
            count = 0;
            mid = (left + right) / 2;
            for (int num : times) {
                count += mid / num;
            }

            if (count < n) {
                left = mid + 1;
            }

            else {
                if (mid < answer) {
                    answer = mid;
                }
                right = mid - 1;
            }

        }

        return answer;
    }
}