// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
// Example:
//
//
// Input:
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// Output: 7
// Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//
//


/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (45.87%)
 * Total Accepted:    217K
 * Total Submissions: 471.4K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 * 
 * 
 */
class Solution {
    public int minPathSum(int[][] grid) {
        // d(0,0) = a(0,0)
        // d(0,j) = d(0,j-1) + a(0,j)
        // d(i,0) = d(i-1,0) + a(i,0)
        // d(i,j) = min(d(i-1,j), d(i,j-1)) + a(i,j)
        int m = grid.length;
        int n = grid[0].length;
        int[][] d = new int[m][n];
        d[0][0] = grid[0][0];

        for (int i=1; i<m; ++i) d[i][0] = d[i-1][0] + grid[i][0];
        for (int j=1; j<n; ++j) d[0][j] = d[0][j-1] + grid[0][j];

        for (int i=1;i<m;++i) 
            for (int j=1;j<n;++j)
                d[i][j] = Math.min(d[i-1][j], d[i][j-1]) + grid[i][j];
        return d[m-1][n-1];
    }
}


