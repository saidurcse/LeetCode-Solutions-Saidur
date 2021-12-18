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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        
        int len = 1;
        ListNode fast = head, slow = head;
        while(fast.next != null){
            len++;
            fast = fast.next;
        }
        
        k = k % len;
        
        for(int i = 1; i < len - k; i++)
            slow = slow.next;
        
        fast.next = head;
        head = slow.next;
        slow.next = null;
        
        return head;
    }
}