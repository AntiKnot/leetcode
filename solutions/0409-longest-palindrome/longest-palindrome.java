// Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
//
// This is case sensitive, for example "Aa" is not considered a palindrome here.
//
// Note:
// Assume the length of given string will not exceed 1,010.
//
//
// Example: 
//
// Input:
// "abccccdd"
//
// Output:
// 7
//
// Explanation:
// One longest palindrome that can be built is "dccaccd", whose length is 7.
//
//


class Solution {
    public int longestPalindrome(String s) {
        int [] d = new int[256];
        int oddNum= 0;
        for (char c: s.toCharArray())
            ++d[c];
        for (int count: d)
            if (count % 2 ==1)
                ++oddNum;
        int unUsed = Math.max(0,oddNum-1);
        return s.length() - unUsed;
                
    }
}
