import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        int count0 = 0;
        int count1 = 0;
        char prev = st.charAt(0);
        if (prev == '0') {
            count0++;
        }
        else {
            count1++;
        }
        for (int i = 1; i < st.length(); i++) {
            if (prev == st.charAt(i)) {
                continue;
            }
            else if (st.charAt(i) == '0') {
                count0++;
            }
            else {
                count1++;
            }
            prev = st.charAt(i);
        }
        System.out.println(count0 < count1 ? count0 : count1);
    }
}
