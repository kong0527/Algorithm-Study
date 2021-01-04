import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_11652 {
    static int count = 0;
    static long ans = 0;
    static HashMap<Long, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        map = new HashMap<Long, Integer>();

        for (int i = 0; i < num; i++) {
            long key = Long.parseLong(br.readLine());
            if (i == 0) {
                count++;
                ans = key;
                map.put(key, 1);
            }

            else {
                solve(key);
            }
        }
        System.out.println(ans);
    }
    public static void solve(long key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.put(key, ++value);
        }

        else {
            map.put(key, 1);
        }

        if (count < map.get(key)) {
            count = map.get(key);
            ans = key;
        }
        else if (count == map.get(key)) {
            ans = ans < key ? ans : key;
        }
    }
}
