import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String answer = "";
        String st[] = s.split(" ");
        int arr[] = new int[st.length];

        for (int i = 0; i < st.length; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }
        
        Arrays.sort(arr);
        answer = String.valueOf(arr[0]) + " " + String.valueOf(arr[arr.length-1]);
        return answer;
    }
}