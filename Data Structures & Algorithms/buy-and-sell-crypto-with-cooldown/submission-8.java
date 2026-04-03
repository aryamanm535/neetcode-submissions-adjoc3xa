class Solution {
    Map<String, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(prices, 0, false);
    }

    int dfs(int[] prices, int i, boolean holding) {
        if (i >= prices.length) 
            return 0;

        String key = i + "," + holding;
        if (dp.containsKey(key)) 
            return dp.get(key);

        int ans = dfs(prices, i + 1, holding); // skip

        if (!holding) {
            ans = Math.max(ans, -prices[i] + dfs(prices, i + 1, true));
        } else {
            ans = Math.max(ans, prices[i] + dfs(prices, i + 2, false));
        }

        dp.put(key, ans);
        return ans;
    }
}