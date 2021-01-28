import java.util.HashSet;
import java.util.Set;

public class Main {
    static Set<Integer> set = new HashSet<Integer>();

    public static void main(String[] args) {
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        int arr[] = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        for (int i = 1; i <= numbers.length(); i++) {
            permutation(arr, 0, numbers.length(), i);
        }
        return set.size();
    }

    static void permutation(int[] arr, int depth, int n, int r) {
        if(depth == r) {
            checkPrime(arr, r);
            return;
        }

        for(int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    static void checkPrime(int[] arr, int r) {
        StringBuilder s = new StringBuilder();
        boolean flag = true;

        for (int i = 0; i < r; i++) {
            s.append(arr[i]);
        }

        int num = Integer.parseInt(String.valueOf(s));
        if (num == 1 || num == 0) {
            flag = false;
        }

        for (int n = 2; n <= Math.sqrt(num); n++) {
            if (num % n == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            set.add(num);
        }
    }

}
