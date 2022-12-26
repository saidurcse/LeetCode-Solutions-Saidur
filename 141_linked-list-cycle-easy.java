import java.io.*;
import java.util.*;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
This approach is simply brilliant. Love it.

For those of you who can not comprehend what is going on. Basically, the slow variable moves only one time each loop,
while fast variable moves two times. Eventually fast variable will catch up the slow one if the Linked List has a cycle in it.
*/

public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null) {
            return false;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                return true;
            }
        }
        return false;
        
    }
}
