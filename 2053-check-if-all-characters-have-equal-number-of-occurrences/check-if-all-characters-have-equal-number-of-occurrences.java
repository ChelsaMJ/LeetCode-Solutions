class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        Integer firstCount = null;
        
        for (int count : frequencyMap.values()) {
            if (firstCount == null) {
                firstCount = count;
            } else if (!firstCount.equals(count)) {
                return false;
            }
        }
        
        return true;
    }}