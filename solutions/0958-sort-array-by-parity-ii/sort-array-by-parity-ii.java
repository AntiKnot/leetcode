// Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
//
// Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
//
// You may return any answer array that satisfies this condition.
//
//  
//
// Example 1:
//
//
// Input: [4,2,5,7]
// Output: [4,5,2,7]
// Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
//
//
//  
//
// Note:
//
//
// 	2 <= A.length <= 20000
// 	A.length % 2 == 0
// 	0 <= A[i] <= 1000
//
//
//
//  
//


class Solution {
    public boolean isEven(int n) {
        if ((n & 1) == 0) {
            return true;
        } else {
            return false;
        }
    }
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int pointer_odd = 1;
        int pointer_even = 0;
        for (int i = 0; i < A.length; ++i) {
            if (isEven(A[i])) {
                result[pointer_even] = A[i];
                pointer_even += 2;
            } else {
                result[pointer_odd] = A[i];
                pointer_odd += 2;
            }
        }
        return result;
    }
}
