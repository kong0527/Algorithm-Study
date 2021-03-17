import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 배열의 최솟값을 저장할 인덱스
        int min = 0;
        // 배열의 최댓값을 저장할 인덱스
        int max = people.length-1;
        // 배열을 오름차순으로 정렬
        Arrays.sort(people);

        while (min <= max) {
            // 최솟값 + 최댓값의 합이 limit보다 클 경우 max만 따로 보낸다.
            if (people[min] + people[max] > limit) {
                max--;
            }
            // 최솟값 + 최댓값의 합이 limit보다 작거나 같을 경우 둘을 함께 보낸다.
            else {
                max--;
                min++;
            }
            // 구명보트를 보낸 횟수를 1증가시킨다.
            answer++;
        }

        return answer;
    }
}