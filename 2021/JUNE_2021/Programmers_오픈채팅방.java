import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        StringBuilder sb = new StringBuilder();
        // 유저 아이디와 닉네임의 쌍을 저장할 hashmap
        HashMap<String, String> map = new HashMap<>();

        // 최종 유저 아이디와 닉네임을 알기 위해 map에 넣는다.
        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");
            if (!tmp[0].equals("Leave")) {
                map.put(tmp[1], tmp[2]);
            }
        }

        for (int i = 0; i < record.length; i++) {
            String[] tmp = record[i].split(" ");
            if (tmp[0].equals("Enter")) {
                sb.append(map.get(tmp[1]) + "님이 들어왔습니다.-");
            }

            else if (tmp[0].equals("Leave")) {
                sb.append(map.get(tmp[1]) + "님이 나갔습니다.-");
            }
        }

        answer = sb.toString().split("-");

        return answer;
    }
}