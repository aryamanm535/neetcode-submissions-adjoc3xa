class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int largest = Arrays.stream(piles).max().getAsInt();
        int lo = 1;
        int hi = largest;
        int res = largest;

        while(lo < hi){
            int mid = (lo+hi)/2;
            long time = 0;
            for(int p : piles){
                time += Math.ceil((double)p/mid);
            }
            if(time <= h){
                res = mid;
                hi = mid;
            }
            else{
                lo = mid+1;
            }
        }
        return res;
    }
}

