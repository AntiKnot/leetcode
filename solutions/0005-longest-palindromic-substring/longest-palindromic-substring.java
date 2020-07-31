// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example 1:
//
//
// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
// Input: "cbbd"
// Output: "bb"
//
//


class Solution {
    public String longestPalindrome(String s) {
        if (s==null || s.length()==0) return "";
        int n = s.length(), start = 0, maxlen = 0;
        boolean d[][] = new boolean[n][n];
        for (int i = n-1; i>=0; --i) {
            for (int j = i; j<n; ++j) {
                if (i==j) d[i][j] = true;
                else if (i+1==j) d[i][j] = s.charAt(i) == s.charAt(j);
                else d[i][j] = s.charAt(i) == s.charAt(j) && d[i+1][j-1];
                if (d[i][j] && (j-i+1) > maxlen) {
                    start = i;
                    maxlen = j-i+1;
                }
            }
        }
        return s.substring(start, start + maxlen);
    }
}
