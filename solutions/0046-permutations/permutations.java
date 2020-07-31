// Given a collection of distinct integers, return all possible permutations.
//
// Example:
//
//
// Input: [1,2,3]
// Output:
// [
//   [1,2,3],
//   [1,3,2],
//   [2,1,3],
//   [2,3,1],
//   [3,1,2],
//   [3,2,1]
// ]
//
//


class Solution {
    void permuteRec(List<Integer> nums, int start, List<List<Integer>> result) {
        if (start == nums.size()) {
            result.add(new ArrayList<>(nums));
        } else {
            for (int i = start; i < nums.size(); ++i) {
                Collections.swap(nums, i, start);
                permuteRec(nums, start + 1, result);
                Collections.swap(nums, i, start);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>(); 
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num: nums) list.add(num);
        
        permuteRec(list, 0, result);
        return result;
    }
}
