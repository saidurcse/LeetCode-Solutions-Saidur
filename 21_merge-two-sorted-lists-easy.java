import java.io.*;
import java.util.*;

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

/*  //Using recursion
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
	if(l1 == null) return l2;
	if(l2 == null) return l1;
	if(l1.val < l2.val){
		l1.next = mergeTwoLists(l1.next, l2);
		return l1;
	} else{
		l2.next = mergeTwoLists(l1, l2.next);
		return l2;
	}
   }
*/

class Solution {
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        // if both lists are empty then merged list is also empty
        // if one of the lists is empty then other is the merged list
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        ListNode mergedHead = null;
        if (head1.val <= head2.val) {
            mergedHead = head1;
            head1 = head1.next;
        } else {
            mergedHead = head2;
            head2 = head2.next;
        }

        ListNode mergedTail = mergedHead;

        /* Compare the data of the two lists whichever lists' data is smaller,
	append it into tail and advance the head to the next Node */
        while (head1 != null && head2 != null) {
            ListNode temp = null;
            if (head1.val <= head2.val) {
                temp = head1;
                head1 = head1.next;
            } else {
                temp = head2;
                head2 = head2.next;
            }

            /* Advance the tail */
            mergedTail.next = temp;
            mergedTail = temp;
        }

        // adding remaining elements of bigger list.
        if (head1 != null) {
            mergedTail.next = head1;
        } else if (head2 != null) {
            mergedTail.next = head2;
        }

        return mergedHead;
    }
}
