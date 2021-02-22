class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(target, numbers, 0, 0);
    }

    public int dfs(int target, int[] numbers, int sum, int idx) {
        if (idx == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        return dfs(target, numbers,sum + numbers[idx], idx + 1) + dfs(target, numbers,sum - numbers[idx], idx + 1);
    }
}