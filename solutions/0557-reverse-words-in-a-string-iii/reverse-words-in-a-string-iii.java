// Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
// Example 1:
//
// Input: "Let's take LeetCode contest"
// Output: "s'teL ekat edoCteeL tsetnoc"
//
//
//
// Note:
// In the string, each word is separated by single space and there will not be any extra space in the string.
//


class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length()==0) return s;
        char[] c = s.toCharArray();
        int start =0, end=0;
        while (start<c.length) {
            while (end<c.length && c[end] != ' ') ++end;
            for (int i=start,j=end-1;i<j;++i,--j){
                char tmp = c[i];
                c[i] = c[j];
                c[j] = tmp;
            }
            start = end + 1;
            end = start;
        }
        return new String(c);
    }
}
