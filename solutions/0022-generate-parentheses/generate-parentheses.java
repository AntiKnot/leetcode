//
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
// For example, given n = 3, a solution set is:
//
//
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
//


class Solution {
    void generate(List<String> result, String str, int left, int right) {
        if (left==0 && right==0) {
            result.add(str);
        } else {
            if (left > 0) generate(result, str+'(', left-1,right);
            if (right > left) generate(result, str+')', left, right-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        if (n < 0 ) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        generate(result, "", n, n);
        return result;
    }
}
