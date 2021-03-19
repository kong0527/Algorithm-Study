import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int arr[][];
    static int num;
    static ArrayList<Location> chicken;
    static ArrayList<Location> home;
    static int min;
    static int index[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        // 입력받은 배열을 저장
        arr = new int[Integer.parseInt(st[0])][Integer.parseInt(st[0])];
        // 폐업시키지 않을 치킨집의 최대 개수
        num = Integer.parseInt(st[1]);
        // 치킨집 위치의 좌표를 저장
        chicken = new ArrayList<>();
        // 집 위치의 좌표를 저장
        home = new ArrayList<>();
        // 치킨거리의 최솟값
        min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                arr[i][j] = Integer.parseInt(st[j]);
                if (Integer.parseInt(st[j]) == 2) {
                    chicken.add(new Location(i, j));
                }

                else if (Integer.parseInt(st[j]) == 1) {
                    home.add(new Location(i, j));
                }
            }
        }
        // 치킨집 좌표들의 크기만큼 배열 생성 (인덱스들을 조합으로 고르기 위해)
        index = new int[chicken.size()];
        // 백트래킹을 위한 visited 배열
        visited = new boolean[chicken.size()];
        // chicekn의 인덱스들을 저장하기 위한 배열
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        // chicken의 인덱스들의 조합의 경우의 수 구하기
        combination(index, visited, 0, chicken.size(), num);
        System.out.println(min);
    }

    static void combination(int[] index, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            // 모두 골랐으면 pick 호출
            pick(index,visited, n);
            return;
        }

        // 백트래킹으로 조합의 경우의 수 구하기
        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(index, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    static void pick(int[] index, boolean[] visited, int n) {
        // 조합의 결과인 comb 배열의 인덱스를 저장할 배열
        int idx = 0;
        // 조합의 결과를 저장할 배열
        int comb[] = new int[num];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                // 방문한 곳 (선택된 곳)이면 comb에 값을 저장한다.
                comb[idx++] = index[i];
            }
        }
        // 뽑혀진 치킨집들의 치킨 거리를 구하는 함수
        distance(comb);
    }

    static void distance(int[] comb) {
        // 현재 뽑혀진 comb 배열로 얻을 수 있는 도시의 치킨 거리중 최솟값을 저장할 값
        int dis = 0;
        for (int i = 0; i < home.size(); i++) {
            int currMin = Integer.MAX_VALUE;
            for (int j = 0; j < comb.length; j++) {
                // 집의 좌표를 기준으로 가장 짧은 치킨 거리를 구한다.
                int sum = Math.abs(chicken.get(comb[j]).x - home.get(i).x) + Math.abs(chicken.get(comb[j]).y - home.get(i).y);
                currMin = Math.min(sum, currMin);
            }
            // 가장 짧은 치킨 거리를 dis에 더해준다.
            dis += currMin;
        }
        // 현재의 치킨 거리와 비교해 min값 갱신
        min = Math.min(dis, min);
    }
}

class Location {
    int x, y;
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
