import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if (hash.containsKey(clothes[i][1])) {
                int value = hash.get(clothes[i][1]) + 1;
                hash.put(clothes[i][1], value);
            }
            else {
                hash.put(clothes[i][1], 1);
            }
        }

        for(String key: hash.keySet()) {
            answer *= (hash.get(key) + 1);
        }

        return --answer;
    }
}