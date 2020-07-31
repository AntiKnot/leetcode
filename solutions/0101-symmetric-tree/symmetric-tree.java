// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
//
//
//  
//
// But the following [1,2,2,null,3,null,3] is not:
//
//
//     1
//    / \
//   2   2
//    \   \
//    3    3
//
//
//  
//
// Follow up: Solve it both recursively and iteratively.
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
    boolean isMirror(TreeNode s,TreeNode t) {
        if (s != null && t != null) {
            return s.val == t.val && isMirror(s.left, t.right) && isMirror(s.right, t.left);
        }
        else return s == null && t == null;
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    /* 
    boolean isSymmetric(TreeNode s, TreeNode t) {
        if (s != null && t != null)
            return s.val == t.val && isSymmetric(s.left, t.right) && isSymmetric(s.right,t.left);
        else return s == null && t == null;
    }
    // Time: O(n), Space: O(n)
    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null ) return true;
        return isSymmetric(root.left, root.right);
    }
    // Time: O(n), Space: O(n)
    public boolean isSymmetricIterative(TreeNode root) {
        if (root == null ) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.empty()) {
            TreeNode s = stack.pop, t = stack.pop();
            if (s == null && t == null) continue;
            if (s == null || t == null) return false;
            if (s.val != t.val) return false;
            
            stack.push(s.left);
            stack.push(t.right);
            stack.push(s.right);
            stack.push(t.left);
        }
        return True
    }
    */
    
}
