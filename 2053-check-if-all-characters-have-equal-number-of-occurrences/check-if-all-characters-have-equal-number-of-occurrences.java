class Solution {
    public boolean areOccurrencesEqual(String s) {

        HashMap<Character, Integer> ch = new HashMap<>();

        for(char c : s.toCharArray()){
            ch.put(c, ch.getOrDefault(c,0)+1);
        }

        int count = ch.get(s.charAt(0));

        for(char key : ch.keySet()){
            if(ch.get(key)!=count){
                return false;
            }
        }
        return true;

    }
}