/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
      if (head == null) {
          return head;
      }
      ListNode dummyOdd = new ListNode(0);
      ListNode dummyEven = new ListNode(0);
      ListNode odd = dummyOdd;
      ListNode even = dummyEven;
      int index = 1;
      while (head != null) {
          if ((index & 1) == 1) {
              odd.next = head;
              odd = odd.next;
          } else {
              even.next = head;
              even = even.next;
          }
          head = head.next;
          index++;
      }
      odd.next = dummyEven.next;
      even.next = null;
      return dummyOdd.next;
    }
}