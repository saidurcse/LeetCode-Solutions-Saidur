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
    public boolean isPalindrome(ListNode head) {
        //ArrayList Code
        ArrayList<Integer> list = new ArrayList<>();

        ListNode temp= head;
        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        for(int i =0; i < list.size() / 2;i++) {
            if(list.get(i) != list.get(list.size() - 1 - i))
                return false;
        }

        return true;
        /*
        //Reverse list method
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head;

        // make the slow pointer points to middle element
        // this is used to keep the slow to the left element in case of even length list
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the list on the right of slow
        slow.next = Reverse(slow.next);

        // increment the slow pointer by one
        slow = slow.next;

        while(slow != null) {
            if(head.val != slow.val)
                return false;
            slow = slow.next;
            head = head.next;
        }

        return true;
    }
    
    // method to reverse a linked list
    public ListNode Reverse(ListNode head) {
        ListNode prev, curr, nxt;
        prev = null;
        curr = head;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    */
}
