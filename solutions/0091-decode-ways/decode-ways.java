// A message containing letters from A-Z is being encoded to numbers using the following mapping:
//
//
// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
//
//
// Given a non-empty string containing only digits, determine the total number of ways to decode it.
//
// Example 1:
//
//
// Input: "12"
// Output: 2
// Explanation: It could be decoded as "AB" (1 2) or "L" (12).
//
//
// Example 2:
//
//
// Input: "226"
// Output: 3
// Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
//


class Solution {
    private boolean isValidTwoDigital(char a, char b) {
        return (a == '1' &&  b <= '9') || (a == '2' && b <='6');
    }
    
    public int numDecodings(String s) {
        int first = 1;
        int second = s.charAt(0) != '0' ? 1:0;
        for (int i = 2; i <= s.length(); ++i) {
            int third = 0;
            if (s.charAt(i-1) != '0') third +=second;
            if (isValidTwoDigital(s.charAt(i-2), s.charAt(i-1))) third+=first;
            first = second;
            second = third;
        }
        return second;
    }
}
