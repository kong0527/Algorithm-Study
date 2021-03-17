class Solution {
    public String solution(String new_id) {
        String answer = "";
        // 1단계: 대문자 -> 소문자
        new_id = new_id.toLowerCase();

        String tmp = "";

        // 2단계: 소문자, 숫자, -, _, . 만 문자열에 넣음 
        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (Character.isLowerCase(c) || Character.isDigit(c) ||
                    c == '-' || c == '_' || c == '.') {
                tmp += Character.toString(c);
            }
        }

        new_id = tmp;

        // 3단계: .이 연속되면 .을 하나로
        new_id = new_id.replaceAll("[.]{2,}", ".");


        // 4단계: 처음이나 끝의 . 제거
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1, new_id.length());
        }

        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length()-1);
        }

        // 5단계: 빈 문자열이면 "a" 대입
        if (new_id.length() == 0) {
            new_id = "a";
        }

        // 6단계: 길이가 16자 이상이면 15개 까지만
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }

        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length()-1);
        }

        // 7단계: 길이가 2자 이하면 길이가 3이 될 때까지 반복
        int size = new_id.length();
        String s = Character.toString(new_id.charAt(size-1));

        for (int i = 0; i < 3-size; i++) {
            new_id += s;
        }

        answer = new_id;

        return answer;
    }
}