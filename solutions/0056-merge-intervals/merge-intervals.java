// Given a collection of intervals, merge all overlapping intervals.
//
// Example 1:
//
//
// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
//
//
// Example 2:
//
//
// Input: [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
//


class Solution {
  public int[][] merge(int[][] intervals) {
    int[][] result = new int[intervals.length][2];
    int size = 0;
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

    for (int[] in: intervals) {
      if (size == 0 || result[size-1][1] < in[0]) {
        result[size][0] = in[0];
        result[size][1] = in[1];
        ++size;
      } else {
        result[size-1][1] = Math.max(result[size-1][1], in[1]);
      }
    }
    return Arrays.copyOf(result, size);
  }
}
