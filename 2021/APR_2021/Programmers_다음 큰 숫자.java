class Solution {
    public static int solution(int n) {
        int answer = n + 1;
        int count = countOne(n);

        while (true) {
            // n의 다음 수 부터 이진수의 1의 갯수를 세서 같으면 while문을 빠져나온다.
            if (count == countOne(answer++)) {
                break;
            }
        }
        // 앞에서 answer이 1 증가되었기 때문에 1을 빼서 return
        return --answer;
    }

    // n의 이진수에서 1의 갯수를 세는 함수
    public static int countOne(int n) {
        int count = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n /= 2;
        }
        return count;
    }
}