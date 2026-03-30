class Solution {
    private Map<Integer, Boolean> memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        memo = new HashMap<>(); //  stores if s[i:] can be segmented
        memo.put(s.length(), true);
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int i){
        if(memo.containsKey(i))
            return memo.get(i);
        
        for(String w : wordDict){
            if(i + w.length() <= s.length() && w.equals(s.substring(i, i + w.length()))){
                if(dfs(s, wordDict, i + w.length())){
                    memo.put(i, true);
                    return true;
                }
            }
        }
        memo.put(i, false);
        return false;
    }
}
