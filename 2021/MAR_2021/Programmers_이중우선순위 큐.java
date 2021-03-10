import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        // 최소 힙 선언
        PriorityQueue<Integer> min = new PriorityQueue<>();
        // 최대 힙 선언
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            // 들어온 operaiont을 공백을 기준으로 나눔
            String[] st = operation.split(" ");
            // I 이면 값을 넣는다.
            if (st[0].equals("I")) {
                min.add(Integer.parseInt(st[1]));
                max.add(Integer.parseInt(st[1]));
            }
            else {
                // D일 때 큐가 비어있으면 그냥 지나친다.
                if (max.isEmpty()) {
                    continue;
                }

                // D 1 이면 최댓값을 제거하고 최소 힙에서도 이 값을 제거해준다.
                if (st[1].equals("1")) {
                    int num = max.poll();
                    min.remove(num);
                }

                // D -1이면 최솟값을 제거하고 최대 힙에서도 이 값을 제거해준다.
                else {
                    int num = min.poll();
                    max.remove(num);
                }
            }
        }

        // 힙이 비어있다면 0,0을 반환한다.
        if (max.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }

        // 힙에 값이 있다면 최댓값, 최솟값을 반환한다.
        else {
            answer[0] = max.poll();
            answer[1] = min.poll();
        }

        return answer;
    }
}