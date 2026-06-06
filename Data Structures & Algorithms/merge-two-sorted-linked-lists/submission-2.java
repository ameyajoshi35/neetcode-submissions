/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2==null) return list2;
        if(list1 == null && list2!=null) return list2;
        if(list1 != null && list2==null) return list1;
        ListNode newHead = null;
        ListNode curr = null;

        ListNode curr1 = list1;
        ListNode curr2 = list2;

        while(curr1 != null && curr2 != null) {

            if(newHead == null && curr1.val <= curr2.val) {
                newHead = curr1;
                curr = curr1;
                curr1 = curr1.next;
                continue;
            } else if (newHead == null) {
                newHead = curr2;
                curr = curr2;
                curr2 = curr2.next;
                continue;
            }

            if(curr1.val <= curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
                curr = curr.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
                curr = curr.next;
                
            }



        }
        while(curr1 != null) {
            curr.next = curr1;
            curr1 = curr1.next;
            curr = curr.next;
        }

        while(curr2 != null) {
            curr.next = curr2;
            curr2 = curr2.next;
            curr = curr.next;
        }

        return newHead;

        
    }
}