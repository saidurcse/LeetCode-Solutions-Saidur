import java.io.*;
import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // count char freq, task name doesn't matter, only freq matters
        int[] freq = new int[26];
        for (char c: tasks) freq[c - 'A']++;
        // sort first, so we have max freq at freq[25]
        Arrays.sort(freq);
        int time = 0;
        while (freq[25] > 0) { // while we still have task to do, start from most freq task
            // GREEDY
            // each round/row, try to finish n tasks
            for (int i = 0, p = 25; i <= n; i++) { // n is the cooling down factor, p points to the next task to consume
                if (p >= 0 && freq[p] > 0) { // if there is still task to do
                    freq[p]--; // do task
                    p--;       // move p to next freq task
                    time++;    // take one cycle
                } else if (freq[25] != 0) { // if this is NOT last row, need to fill in idle cycle
                    time++;    // take one cycle
                } // else freq[25] == 0 .   no more task to do and last row. we WON'T fill in idle cycle
            }
            // sort again so next round we're going to start from most freq task and consume n task if possible
            Arrays.sort(freq);
        }
        return time; 
    }
}

/*
Greedy - It's obvious that we should always process the task which has largest amount left.
Put tasks (only their counts are enough, we don't care they are 'A' or 'B') in a PriorityQueue in descending order.
Start to process tasks from front of the queue. If amount left > 0, put it into a coolDown HashMap
If there's task which cool-down expired, put it into the queue and wait to be processed.
Repeat step 3, 4 till there is no task left.
*/

/*
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        
        Map<Character, Integer> taskToCount = new HashMap<>();
        for (char c : tasks) {
            taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
        }
        
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (char c : taskToCount.keySet()) queue.offer(taskToCount.get(c));
        
        Map<Integer, Integer> coolDown = new HashMap<>();
        int currTime = 0;
        while (!queue.isEmpty() || !coolDown.isEmpty()) {
            if (coolDown.containsKey(currTime - n - 1)) {
                queue.offer(coolDown.remove(currTime - n - 1));
            }
            if (!queue.isEmpty()) {
                int left = queue.poll() - 1;
        	if (left != 0) coolDown.put(currTime, left);
            }
            currTime++;
        }
        
        return currTime;
    }
}
*/
