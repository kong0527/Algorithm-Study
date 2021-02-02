import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class BOJ_1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int aNum = Integer.parseInt(st[0]);
        int bNum = Integer.parseInt(st[1]);
        int count = 0;
        TreeSet<Integer> arrA = new TreeSet<>();
        TreeSet<Integer> arrB = new TreeSet<>();

        st = br.readLine().split(" ");
        for (int i = 0; i < aNum; i++) {
            arrA.add(Integer.parseInt(st[i]));
        }

        st = br.readLine().split(" ");
        for (int i = 0; i < bNum; i++) {
            if (arrA.contains(Integer.parseInt(st[i]))) {
                count++;
            }
        }

        System.out.println(aNum + bNum - count * 2);
    }
}
