class Solution {
    public boolean canJump(int[] nums) {
        return recurse(nums, 0);
    }

    private boolean recurse(int[]nums, int idx){
        if(idx >= nums.length)
            return false;

        if(idx == nums.length-1)
            return true;

        for(int i = 1; i <= nums[idx]; i++){
            if(recurse(nums, idx + i))
                return true;
        }
        return false;
    }
}
