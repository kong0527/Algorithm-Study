import java.util.regex.Pattern;

class Solution {
    public String solution(String s) {
        String answer = "";
        // s의 문자열을 우선 모두 소문자로 바꿔준다.
        s = s.toLowerCase();
        String tmp = "";
        
        for (int i = 0; i < s.length(); i++) {
            // 현재 문자열이 공백이라면 지금까지 담긴 tmp 문자열을 규칙에 맞게 변환한다.
            if (s.charAt(i) == ' ') {
                if(!tmp.equals("")) {
                    answer += change(tmp);
                }
                tmp = "";
                answer += " ";
            }

            // 현재 문자열이 공백이 아니라면 tmp에 담는다.
            else {
                tmp += Character.toString(s.charAt(i));
            }
        }

        // tmp에 남은 문자열이 있을 경우
        if (!tmp.equals("")) {
            // 그 문자열이 공백이면 그대로 answer에 공백을 넣어준다.
            if (s.charAt(s.length() - 1) == ' ') {
                answer += " ";
            } 
            
            // 아니라면 규칙에 맞게 변환해준다.
            else {
                answer += change(tmp);
            }
        }
        
        return answer;
    }
    
    public String change(String s) {
        String result = "";
        String letter = Character.toString(s.charAt(0));

        // 앞 글자가 소문자이면 대문자로 바꾼 후 result에 넣는다
        if (Pattern.matches("^[a-z]*$", letter)) {
            result += letter.toUpperCase() + s.substring(1);
        }

        // 아니면 그대로 result에 넣는다
        else {
            result += s;
        }

        return result;
    }
}