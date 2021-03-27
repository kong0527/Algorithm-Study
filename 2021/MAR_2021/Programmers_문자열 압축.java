class Solution {
    public int solution(String s) {
        // answer의 초기값을 설정
        int answer = s.length();
        // i는 한 번에 자를 문자열의 단위
        for (int i = 1; i < s.length(); i++) {
            // 압축할 문자열을 저장할 변수
            String compression = "";
            // j는 문자열을 자를 때 시작되는 인덱스를 나타낼 것임
            for (int j = 0; j < s.length(); j+=i) {
                // 같은 문자열의 개수를 셀 변수
                int count = 1;
                // 인덱스 j부터 i개까지 자른 문자열
                String curr = "";
                // 잘린 문자열이 마지막 부분일 경우
                if (j > s.length() - i) {
                    compression += s.substring(j);
                    break;
                }
                // 아닐 경우 i만큼 자른다.
                else {
                    curr = s.substring(j, j + i);
                }
                // 다른 문자열이 나올 때까지 검사
                while (true) {
                    // j가 마지막으로 자를 문자열이면 그대로 compression에 저장
                    if (j == s.length()-i) {
                        if (count == 1) {
                            compression += curr;
                        }
                        else {
                            compression += String.valueOf(count) + curr;
                        }
                        break;
                    }
                    // 현재 문자열 다음 단위를 저장할 변수
                    String tmp = "";
                    // 다음 문자열이 s의 마지막인 경우
                    if (j + i + i > s.length()) {
                        tmp = s.substring(j+i);
                    }
                    else {
                        tmp = s.substring(j + i, (j + i) + i);
                    }
                    // curr과 tmp가 같지 않으면 curr과 count값을 compression에 저장
                    if (!curr.equals(tmp)) {
                        if (count == 1) {
                            compression += curr;
                        }
                        else {
                            compression += String.valueOf(count) + curr;
                        }
                        break;
                    }
                    // 같으면 count값을 1 증가시키고 j를 다음 인덱스로 이동
                    else {
                        count++;
                        j += i;
                    }
                }
            }
            // answer값 갱신
            answer = Math.min(compression.length(), answer);
        }
        return answer;
    }
}