class Solution {
    public int coinChange(int[] coins, int amount) {
        // memo[rem] stores answer for remaining amount rem
        // -2 means "not computed yet"
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);

        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int rem, int[] memo) {
        // Base case: exact amount formed
        if (rem == 0) {
            return 0;
        }

        // Base case: invalid path
        if (rem < 0) {
            return -1;
        }

        // If already computed, return stored answer
        if (memo[rem] != -2) {
            return memo[rem];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = dfs(coins, rem - coin, memo);

            // Only use valid subproblems
            if (result != -1) {
                minCoins = Math.min(minCoins, 1 + result);
            }
        }

        // Store result in memo
        memo[rem] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins;
        return memo[rem];
    } 
}