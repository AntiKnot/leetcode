// Given a singly linked list, determine if it is a palindrome.
//
// Example 1:
//
//
// Input: 1->2
// Output: false
//
// Example 2:
//
//
// Input: 1->2->2->1
// Output: true
//
// Follow up:
// Could you do it in O(n) time and O(1) space?
//


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> s = new Stack<>();
        for (ListNode p = head; p != null; p = p.next)
            s.push(p.val);
        for (ListNode p = head; p != null; p = p.next)
            if (p.val != s.pop())
                return false;
        return true;
    }
    */
    public boolean isPalindrome(ListNode head) {
        int len = 0;
        for (ListNode p = head; p!=null; p=p.next, ++len);
        ListNode cur = head;
        ListNode pre = null;
        for (int i=0; i<len/2; ++i){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (len%2==1) cur =cur.next;
        for (; pre!=null && cur!=null;pre=pre.next,cur=cur.next)
            if (pre.val != cur.val) return false;
        return true;
    }
}
