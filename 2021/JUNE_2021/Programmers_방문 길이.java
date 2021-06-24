import java.util.HashSet;

class Solution {
    public int solution(String dirs) {
        HashSet<String> set = new HashSet<>();
        int answer = 0;
        int cx = 0;
        int cy = 0;
        
        for (int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int nx = cx;
            int ny = cy;
            
            if (ch == 'U') {
                cy = cy + 1 > 5 ? cy : cy + 1;
            }

            else if (ch == 'L') {
                cx = cx - 1 < -5 ? cx : cx - 1;
            }

            else if (ch == 'R') {
                cx = cx + 1 > 5 ? cx : cx + 1;
            }

            else {
                cy = cy - 1 < -5 ? cy : cy - 1;
            }
            
            if (nx == cx && ny == cy) {
                continue;
            }
            
            set.add(cx + "" + cy + "" + nx + "" + ny);
            set.add(nx + "" + ny + "" + cx + "" + cy);
            
        }
        
        answer = set.size()/2;
        
        return answer;
    }
}