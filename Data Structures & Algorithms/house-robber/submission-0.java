class Solution {
    int amt;
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        return computeMax(nums, 0, dp);
    }

    int computeMax(int[] nums, int i, int[] dp){
        if(i >= nums.length)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        int curr = 0;
        int rob  = nums[i] + computeMax(nums, i + 2, dp);  // rob this house
        int skip = computeMax(nums, i + 1, dp);             // skip this house

        dp[i] = Math.max(rob, skip);
        return dp[i];

    }
}
