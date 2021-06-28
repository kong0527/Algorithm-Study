class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int sum = 0;

        for (int i = 0; i < a - 1; i++) {
            sum += months[i];
        }

        sum += b - 1;

        answer = days[sum % 7];

        return answer;
    }
}