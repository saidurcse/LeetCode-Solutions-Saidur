import java.io.*;
import java.util.*;

public class Solution {
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode(int x) {
	          val = x;
	          next = null;
	      }
	  }
    
	public ListNode deleteDuplicates(ListNode head) {
		ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) { // Swapping
            next = current.next; 
            current.next = previous; 
            previous = current; 
            current = next;
        }
        head = previous;
        return head;
	}
}
