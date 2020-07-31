// Implement strStr().
//
// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
// Example 1:
//
//
// Input: haystack = "hello", needle = "ll"
// Output: 2
//
//
// Example 2:
//
//
// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
//
//
// Clarification:
//
// What should we return when needle is an empty string? This is a great question to ask during an interview.
//
// For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
//
//  
// Constraints:
//
//
// 	haystack and needle consist only of lowercase English characters.
//
//


class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (needle.length() == 0) return 0;
        int n = haystack.length();
        int m = needle.length();
        
        for (int i=0; i<=n-m; ++i) {
            int j=0, k=i;
            for(; j<m && k<n && needle.charAt(j) == haystack.charAt(k); ++j, ++k);
            if (j == needle.length()) return i;
        }
        return -1;
    }
}
