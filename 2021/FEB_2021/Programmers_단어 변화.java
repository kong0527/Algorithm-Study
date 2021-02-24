class Solution {
    static int answer = 500;
    static boolean visited[];

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        dfs(begin, target, words, 0);
        return answer == 500 ? 0 : answer;
    }

    public void dfs(String begin, String target, String[] words, int count) {
        if (begin.equals(target)) {
            answer = Math.min(count, answer);
            return ;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && check(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, count + 1);
                visited[i] = false;
            }
        }
    }

    public boolean check (String begin, String word) {
        int cnt = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != word.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1 ? true : false;
    }
}