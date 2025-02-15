class Solution {
    public int punishmentNumber(int n) {
        int punishmentNum = 0;
        
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            String squareStr = Integer.toString(square);
            
            if (canPartition(squareStr, i, 0)) {
                punishmentNum += square;
            }
        }
        
        return punishmentNum;
    }
    
    private boolean canPartition(String s, int target, int start) {
        if (target == 0 && start == s.length()) {
            return true;  // We've used up the target and the string
        }
        if (target < 0 || start >= s.length()) {
            return false; // No valid partition found
        }
        
        // Attempt to partition substring from start index
        for (int end = start + 1; end <= s.length(); end++) {
            int partValue = Integer.parseInt(s.substring(start, end));
            if (canPartition(s, target - partValue, end)) {
                return true;
            }
        }

        return false; // No valid partitions found
    }
}
