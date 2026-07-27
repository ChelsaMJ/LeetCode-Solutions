class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        // Stores the last seen index of each ASCII character
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);
        
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            // If character was seen and lies within the current sliding window
            if (lastSeen[c] >= left) {
                left = lastSeen[c] + 1; // Move the left pointer past the duplicate
            }
            
            lastSeen[c] = right; // Update the last seen position of the character
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}