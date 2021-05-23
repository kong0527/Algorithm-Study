import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        // 현재까지 나온 단어들을 저장할 Set
        Set<String> set = new HashSet<>();
        // 이전 단어의 끝 글자를 저장할 변수
        char prev = words[0].charAt(words[0].length()-1);
        int size = 1;
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            // 현재 단어의 첫 단어를 저장할 변수
            char curr = words[i].charAt(0);
            // 현재 단어의 첫 단어와 이전 단어의 끝 단어가 일치하는지 판단
            if (prev != curr) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }

            prev = words[i].charAt(words[i].length()-1);
            set.add(words[i]);

            // set의 크기에 변화가 없다면 중복된 단어라는 뜻
            if (size == set.size()) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                break;
            }
            size = set.size();
        }

        return answer;
    }
}