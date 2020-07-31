// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
//
// return its level order traversal as:
//
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
//
//


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while (!q.isEmpty()) {
            List<Integer> elem = new ArrayList<>();
            int size = q.size();
            
            for (int i = 0; i < size; ++i) {
                TreeNode s = q.poll();
                elem.add(s.val);
                if (s.left != null) q.add(s.left);
                if (s.right != null) q.add(s.right);
            }
            result.add(elem);
        }
        return result;
    }
}
