// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
// Given array nums = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]
//
//


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (23.59%)
 * Total Accepted:    509K
 * Total Submissions: 2.2M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the
 * sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * ⁠ [-1, 0, 1],
 * ⁠ [-1, -1, 2]
 * ]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int k = nums.length-1; k>=2; --k) {
            if (nums[k] < 0) break;
            int target=-nums[k], i=0, j=k-1;
            while(i<j) {
                if (nums[i] + nums[j] == target) {
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(i<j && nums[i+1] == nums[i]) ++i;
                    while(i<j && nums[j-1] == nums[j]) --j;
                    ++i; --j;
                } else if (nums[i] + nums[j] < target){
                    ++i;
                } else {
                    --j;
                }
            }
            while (k>=2 && nums[k-1] == nums[k]) --k;
        }
        return result;
    }

    
}


