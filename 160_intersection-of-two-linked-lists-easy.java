import java.io.*;
import java.util.*;

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

/*
1, Get the length of the two lists.

2, Align them to the same start point.

3, Move them together until finding the intersection point, or the end null
*/
/*
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lenA = length(headA), lenB = length(headB);
    // move headA and headB to the same start point
    while (lenA > lenB) {
        headA = headA.next;
        lenA--;
    }
    while (lenA < lenB) {
        headB = headB.next;
        lenB--;
    }
    // find the intersection until end
    while (headA != headB) {
        headA = headA.next;
        headB = headB.next;
    }
    return headA;
}

private int length(ListNode node) {
    int length = 0;
    while (node != null) {
        node = node.next;
        length++;
    }
    return length;
}
*/

/*
I found most solutions here preprocess linkedlists to get the difference in len.
Actually we don't care about the "value" of difference, we just want to make sure two pointers reach the intersection node at the same time.
*/

public class Solution {
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1, p2;
        p1 = headA;
        p2 = headB;
        //if p1 & p2 have different len, then we will stop the loop after second iteration
        while (p1 != p2) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        //boundary check
        if (p1 == null) {
            return null;
        }
        return p1;
    }
}


