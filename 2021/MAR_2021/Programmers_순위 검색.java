// 정확성 테스트만 통과. 효율성 통과 못한 코드
// 나중에 다시 수정 예정
class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String[] q = query[i].replaceAll(" and", "").split(" ");
            int count = 0;
            for (int j = 0; j < info.length; j++) {
                String st = info[j];
                for (int k = 0; k < 5; k++) {
                    if (k == 4) {
                        int tmp = Integer.parseInt(st.replaceAll("[^0-9]", ""));
                        if (Integer.parseInt(q[k]) <= tmp) {
                            count++;
                        }
                    }
                    else {
                        if (q[k].equals("-")) {
                            continue;
                        }
                        else {
                            if (!st.contains(q[k])) {
                                break;
                            }
                        }
                    }
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}