import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 최소 힙 구현을 위해 pq 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //pq에 scoville의 원소들을 넣어준다.
        for (int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }

        while (true) {
            // pq에서의 최솟값이 K보다 크다면 문제 조건을 달성했으므로 break;
            if (pq.peek() >= K) {
                break;
            }
            // pq의 원소가 둘 이상일 때 음식을 섞는다.
            if (pq.size() > 1) {
                int num1 = pq.poll();
                int num2 = pq.poll();
                pq.add(num1 + num2 * 2);
                answer++;
            }
            // pq의 최솟값이 K보다 크지도 않고, 음식을 섞을수도 없으므로 -1 return
            else {
                return -1;
            }
        }

        return answer;
    }
}