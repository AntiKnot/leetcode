// Given a string, find the length of the longest substring without repeating characters.
//
//
// Example 1:
//
//
// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 
//
//
//
// Example 2:
//
//
// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
//
//
// Example 3:
//
//
// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. 
//              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//
//
//


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] counts = new int[256];
        int i = 0, j = 0, maxLen = 0;
        for (; i<s.length(); ++i) {
            for (; j<s.length(); ++j) {
                if (counts[s.charAt(j)] != 0) break;
                counts[s.charAt(j)] += 1;
            }
            maxLen = Math.max(maxLen, j - i);
            counts[s.charAt(i)] -= 1;
        }
        return maxLen;
    }
}
