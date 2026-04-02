class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, dp, 0);
    }

    int dfs(int[] nums, int[] dp, int i){
        if (i >= nums.length - 1) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        if (nums[i] == 0) {
            return 1000000;
        }
        int res = 1000000;
        int end = Math.min(nums.length, i + nums[i] + 1);
        for (int j = i + 1; j < end; j++) {
            res = Math.min(res, 1 + dfs(nums, dp, j));
        }

        dp[i] = res;
        return res;
    }
}
