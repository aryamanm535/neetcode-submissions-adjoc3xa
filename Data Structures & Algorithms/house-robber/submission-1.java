class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, dp, 0);
    }
    int dfs(int[] nums, int[] dp, int i){
        if(i >= nums.length)
            return 0;
            
        if(dp[i] != -1)
            return dp[i];
        
        int rob = nums[i] + dfs(nums, dp, i+2);
        int skip = dfs(nums, dp, i + 1);

        dp[i] = Math.max(rob, skip);
        return dp[i];
    }
}
