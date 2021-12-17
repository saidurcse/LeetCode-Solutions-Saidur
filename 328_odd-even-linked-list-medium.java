import java.io.*;
import java.util.*;

/*
public static ListNode oddEvenList(ListNode head) {
    if (head == null || head.next == null || head.next.next == null) {
      return head;
    }
    ListNode odds = head;
    ListNode evens = head.next;
    ListNode evensHead = head.next;
    while (evens != null && evens.next != null) {
      odds.next = odds.next.next;
      evens.next = evens.next.next;
      odds = odds.next;
      evens = evens.next;
    }
    odds.next = evensHead;
    return head;
}
*/

/*
Theory

We need to keep track of two seperate linked lists - one for the odd, one for the even. We need to keep track of a count variable to see which parity we are on - even or odd.

*/
Solution

    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1), even = new ListNode(-1);
        ListNode oddPrev = odd, evenPrev = even, curr = head;
        int count = 1;
        while (curr != null) {
            if (count % 2 == 0) {  
                evenPrev.next = curr;
                curr = curr.next;
                evenPrev = evenPrev.next;
                evenPrev.next = null;
            } else {
                oddPrev.next = curr;
                curr = curr.next;
                oddPrev = oddPrev.next;
                oddPrev.next = null;
            }
            count++;
        }
        oddPrev.next = even.next;
        return odd.next;
    }
