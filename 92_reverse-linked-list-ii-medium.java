import java.io.*;
import java.util.*;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy; //pre is the node before orignal M
        ListNode M=head;    //M is after pre
        
        for(int i=1;i<m;i++){ //Move pre and M to orignal place
            pre=pre.next;
            M=M.next;
        }
        
        for(int i=0;i<n-m;i++){  //reverse node
            ListNode current=M.next; //Both pre and M are all fixed, only current is assigned every time to M.next. M is pushed back everytime
            M.next=current.next;     //Move current to the position after pre
            current.next=pre.next;
            pre.next=current;
        }
        
        return dummy.next;
    }
}