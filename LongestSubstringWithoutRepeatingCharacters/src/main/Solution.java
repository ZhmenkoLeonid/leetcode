package main;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int lengthOfLongestSubstring(String s) {
        //   symbol -> index
        Map<Character, Integer> charMap = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charMap.containsKey(c)) {
                start = Math.max(start, charMap.get(c) + 1);
            }
            charMap.put(c, i);
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abba";
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}