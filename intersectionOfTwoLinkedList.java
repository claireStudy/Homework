/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int diff = findLength(headA) - findLength(headB);
        ListNode longerList = diff > 0 ? headA : headB;
        ListNode shorterList = diff > 0 ? headB : headA;
        diff = Math.abs(diff);
        // offset the longer list by diff
        while (diff > 0) {
            longerList = longerList.next;
            diff--;
        }
        while (longerList != null && shorterList != null) {
            if (longerList == shorterList) {
                return longerList;
            }
            longerList = longerList.next;
            shorterList = shorterList.next;
        }
        return null;
    }
    
    private int findLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}