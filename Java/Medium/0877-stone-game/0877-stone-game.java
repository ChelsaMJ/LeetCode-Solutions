class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            dp[i] = piles[i];
        }
        
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                dp[i] = Math.max(piles[i] - dp[i + 1], piles[j] - dp[i]);
            }
        }
        
        return dp[0] > 0;
    }
}