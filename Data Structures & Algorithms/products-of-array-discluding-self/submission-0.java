class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int prod = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCount++;
                continue;
            }
            prod = prod*nums[i];
        }

        if(zeroCount > 1)
            return new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                nums[i] = prod;
                continue;
            }
            if(zeroCount > 0)
                nums[i] = 0;
            else
                nums[i] = prod/nums[i];
        }

        return nums;
    }
}  
