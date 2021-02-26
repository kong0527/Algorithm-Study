import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // 배열을 내림차순으로 정렬하기 위해 citations 배열을 Integer 형태로 바꾸는 과정
        Integer arr[] = Arrays.stream(citations).boxed().toArray(Integer[]::new);;
        Arrays.sort(arr, Collections.reverseOrder());

        for (int i = 0; i < citations.length; i++) {
            // 인용된 횟수가 i보다 작아지는 부분 찾기
            if (arr[i] <= i) {
                answer = i;
                break;
            }
        }

        // 가장 적게 인용된 횟수가 논문의 갯수보다 많을 경우에는 논문의 갯수를 return해야 한다.
        if (answer == 0 && citations[citations.length-1] >= cit기ations.length) {
            return citations.length;
        }

        return answer;
    }
}