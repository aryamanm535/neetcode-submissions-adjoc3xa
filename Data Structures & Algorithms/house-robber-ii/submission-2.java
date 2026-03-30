class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int dp1[] = new int[nums.length];
        int dp2[] = new int[nums.length-1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        
        return Math.max(computeMax(nums, 1, dp1, nums.length), computeMax(nums, 0, dp2, nums.length-1));
    }

    int computeMax(int[] nums, int i, int[] dp, int end){
        if(i >= end)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        int rob  = nums[i] + computeMax(nums, i + 2, dp, end);  // rob this house
        int skip = computeMax(nums, i + 1, dp, end);             // skip this house

        dp[i] = Math.max(rob, skip);
        return dp[i];

    }
}
