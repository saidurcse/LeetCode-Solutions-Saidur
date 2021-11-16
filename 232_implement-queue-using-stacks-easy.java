import java.io.*;
import java.util.*;

class MyQueue {
    
    Stack<Integer> s1;
    Stack<Integer> s2;
    
    public MyQueue() {
        s1 = new Stack();
        s2 = new Stack();
    }
    
    // Push element x to the back of queue.
    public void push(int x) {
      s1.push(x);
    }

    // Removes the element from in front of queue.
    public int pop() {
      peek();      
      return s2.pop();
    }

    // Get the front element.
    public int peek() {
      while (!s1.isEmpty())
        s2.push(s1.pop());
      
      return s2.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
      return s1.isEmpty() && s2.isEmpty();
    }
}
    /*
    Solution 1: Using Two Stacks - Enqueue - O(1) per operation, Dequeue - Amortized O(1) per operation.

    For Enqueue operation, the newly arrived element is always added on top of stack s1.
    For Dequeue operation, we have to remove element from front of the queue. This is the first inserted element in the stack s1 and it is positioned at the bottom of the stack because of the LIFO policy of stack. To remove the bottom element from s1, we have to pop all elements from s1 and to push them on to an additional stack s2, which helps us to store the elements of s1 in reversed order. This way the bottom element of s1 will be positioned on top of s2 and we can simply pop it from stack s2. Once s2 is empty, the algorithm transfer data from s1 to s2 again.
    In essence, the first stack is being used for enqueue and the second for dequeue

Complexity Analysis:

    Time complexity O(1) for Enqueue operation, since appending an element to the stack is a constant time operation.
    Time complexity for Dequeue operation is O(1) amortized and O(n) worst-case. In the worst case scenario when stack s2 is empty, the algorithm pops n elements from stack s1 and pushes n elements to s2, where n is the queue size. This gives 2n operations, which is O(n). But when stack s2 is not empty the algorithm has O(1) time complexity.

Amortized Analysis:

    Amortized analysis gives the average performance over time of each operation in the worst case. The basic idea is that a worst case operation can alter the state in such a way that the worst case cannot occur again for a long time, thus amortizing its cost.
    The worst case time complexity of a single pop operation is O(n). Since we have n pop operations, using the worst-case per operation analysis gives us a total of O(n^2) time
    However, in a sequence of operations the worst case does not occur often in each operation - some operations may be cheap, some may be expensive. Therefore, a traditional worst-case per operation analysis can give overly pessimistic bound. For example, in a dynamic array only some inserts take a linear time, though others - take a constant time.
    The number of times pop operation can be called is limited by the number of push operations before it. Although a single pop operation could be expensive, it is expensive only once per n times, when s2 is empty and when there is a need for data transfer between s1 ands2.
    Hence the total time complexity of the sequence is : n (for push operations) + 2*n (for first pop operation) + n - 1 ( for pop operations) which is O(2*n).This gives O(2n/2n) = O(1) average time per operation.

Time complexity : O(m) for m operations, i.e. O(1) average time per operation, which can be seen from the fact that each element is pushed no more than twice and popped no more than twice.
Space complexity : O(n) - Memory required for additional stack to maintain the FIFO policy of the queue.
*/
    
    /*
    Deque<Integer> inputStack;
    Deque<Integer> outputStack;

    public MyQueue() {
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        peek();
        return outputStack.pop();
    }

    public int peek() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

  }
  */

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */