class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums, target, 0);
    }

    private int dfs(int[] nums, int target, int i){
        if(i >= nums.length)
            return target == 0 ? 1 : 0;
        int ways = 0;
        ways = dfs(nums, target - nums[i], i+1) + dfs(nums, target + nums[i], i+1);
        return ways;
    }   
}
