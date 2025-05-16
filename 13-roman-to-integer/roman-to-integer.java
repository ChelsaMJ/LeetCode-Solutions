import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symb = new HashMap<>();
        symb.put('I', 1);
        symb.put('V', 5);
        symb.put('X', 10);
        symb.put('L', 50);
        symb.put('C', 100);
        symb.put('D', 500);
        symb.put('M', 1000);

        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += symb.get(s.charAt(i));
            if (i + 1 != s.length() && symb.get(s.charAt(i + 1)) > symb.get(s.charAt(i))) {
                res -= 2 * symb.get(s.charAt(i));
            }
        }
        return res;
    }
}
