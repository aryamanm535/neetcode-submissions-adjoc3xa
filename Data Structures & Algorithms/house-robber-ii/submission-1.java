class Solution {
    int amt;
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
            
        int dp1[] = new int[nums.length];
        Arrays.fill(dp1, -1);
        
        int newNums[] = new int[nums.length-1];
        int dp2[] = new int[newNums.length];
        Arrays.fill(dp2, -1);

        for(int i = 0; i < newNums.length; i++)
            newNums[i] = nums[i];
        
        return Math.max(computeMax(nums, 1, dp1), computeMax(newNums, 0, dp2));
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
