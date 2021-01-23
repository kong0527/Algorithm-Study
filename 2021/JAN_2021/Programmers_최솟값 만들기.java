import java.util.Arrays;

class Solution
{
    public int solution(int []A, int []B)
    {
       int answer = 0;
        int tmp1 = 0;
        int tmp2 = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        // A 최소 * B 최대
        int idx = B.length - 1;
        for (int i = 0; i < A.length; i++) {
            tmp1 += A[i] * B[idx--];
        }

        // A 최대 * B 최소
        idx = A.length - 1;
        for (int i = 0; i < B.length; i++) {
            tmp2 += A[idx--] * B[i];
        }

        answer = Math.min(tmp1, tmp2);
        return answer;
    }
}