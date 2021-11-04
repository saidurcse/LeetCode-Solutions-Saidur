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
	  
	/* 100% faster Solution but native solution
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode result = head;
        
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        
        return result;
    }*/
    
	public ListNode deleteDuplicates(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		HashSet<Integer> set = new HashSet<Integer>();
		while(curr != null){
			if(set.contains(curr.val)){
				prev.next = curr.next;
			}else{
				set.add(curr.val);
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
	}
}
