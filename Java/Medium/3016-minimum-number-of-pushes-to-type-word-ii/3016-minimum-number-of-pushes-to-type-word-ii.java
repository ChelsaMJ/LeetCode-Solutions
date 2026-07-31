import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Sort frequencies in ascending order
        Arrays.sort(freq);
        
        int totalPushes = 0;
        int distinctLettersCount = 0;
        
        // Iterate backwards from highest frequency to lowest
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0) break; // No more letters
            
            // Determine multiplier based on slot index (0 to 7 -> 1 push, 8 to 15 -> 2 pushes, etc.)
            int pushesPerChar = (distinctLettersCount / 8) + 1;
            totalPushes += freq[i] * pushesPerChar;
            distinctLettersCount++;
        }
        
        return totalPushes;
    }
}