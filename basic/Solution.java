import java.util.*;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int sum = 0;
        if (s.length() != t.length()) return false;

        // Set up a HashMap
        Map<Character, Integer> myMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            boolean characterCheck = myMap.containsKey(s.charAt(i));
            if (characterCheck) {
                myMap.put(s.charAt(i), myMap.get(s.charAt(i)) + 1);
            } else {
                myMap.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (myMap.containsKey(t.charAt(i))) {
                myMap.put(t.charAt(i), myMap.get(t.charAt(i)) - 1);
            }
        }

        for (int i : myMap.values()) {
            if (i < 0) i = 1; // Base case for string with more duplicate letters
            // e.g "aacc": "ccac"
            sum += i;
        }
        return sum == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "rat";
        String t = "car";
        boolean result = solution.isAnagram(s, t);
        System.out.println(result);
    }
}
