class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int largest = largest(piles);
        int l = 1;
        int r = largest;
        int res = r;
        while(l <= r){
            int k = (r + l)/2;
            int totalTime = 0;
            for(int b : piles){
                totalTime += Math.ceil((double)b/k);
            }
            if(totalTime > h){
                l = k+1;
            }
            else{
                res = k;
                r = k-1;
            }
        }
        return res;
    }

    int largest(int[] arr){
        int res = arr[0];
        for(int i = 1; i < arr.length; i++)
            if(res < arr[i])
                res = arr[i];
        
        return res;
    }
}
