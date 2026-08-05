class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        // Base case: Subarrays of length 1
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
        }
        
        // Build DP table for larger subarray lengths
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i] = Math.max(nums[i] - dp[i + 1], nums[j] - dp[i]);
            }
        }
        
        // If Player 1's score advantage over Player 2 is non-negative, Player 1 wins
        return dp[0] >= 0;
    }
}