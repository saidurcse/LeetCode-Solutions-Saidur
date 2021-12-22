import java.io.*;
import java.util.*;

/*
Basically, this is a graph problem. Notice that each account[ i ] tells us some edges. What we have to do is as follows:

    Use these edges to build some components. Common email addresses are like the intersections that connect each single component for each account.
    Because each component represents a merged account, do DFS search for each components and add into a list. Before add the name into this list, sort the emails. Then add name string into it.

Examples: Assume we have three accounts, we connect them like this in order to use DFS.
{Name, 1, 2, 3} => Name -- 1 -- 2 -- 3
{Name, 2, 4, 5} => Name -- 2 -- 4 -- 5 (The same graph node 2 appears)
{Name, 6, 7, 8} => Name -- 6 -- 7 -- 8
(Where numbers represent email addresses).

Explanation:
First create an undirected adjacency list of (email -> Set(email)) where two emails are connected if they belong to the same account.
Maintain that graph, and also another email -> name mapping that'll be useful later for returning.

Then do a DFS through the emails available (use the email -> name mapping for ease).
Connected components will be collected in each DFS run. Use TreeSet to collect the emails so that you don't have to sort it in the end.
 */

/*
 class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> result = new ArrayList<>();
        if(accounts==null || accounts.size()==0)
            return result;
        
        Map<String, String> names = new HashMap<String, String>(); //email - username
        Map<String, Set<String>> map = new HashMap<String, Set<String>>(); //email - neighbors
        Set<String> emails = new HashSet<String>(); 
        
        for(List<String> list : accounts){
            String name = list.get(0);
            for(int i=1; i<list.size(); i++){
                String email = list.get(i);
                emails.add( email ); 
                names.put( email, name );
                map.putIfAbsent( email, new HashSet<String>() );
                
                if(i==1)
                    continue;
                
                //build the "edge" between two adjacent email-nodes
                map.get( list.get(i-1) ).add( email );
                map.get( email ).add( list.get(i-1) );
            }
        }
        
        Set<String> visited = new HashSet<String>();
        for(String s : emails)
            if( !visited.contains(s) ){
                visited.add(s);
                List<String> buffer = new ArrayList<String>();
                buffer.add(s);
                helper(s, map, visited, buffer);
                Collections.sort(buffer);
                buffer.add(0, names.get(s));
                result.add(buffer);
            }
        return result; 
    }
    
    private void helper(String s, Map<String, Set<String>> map, Set<String> visited, List<String> buffer){
        for(String node : map.get(s))
            if( !visited.contains(node) ){
                visited.add(node);
                buffer.add(node);
                helper(node, map, visited, buffer);
            }
    }
}
 */

Original Solution:

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Set<String>> graph = new HashMap<>();  //<email node, neighbor nodes>
        Map<String, String> name = new HashMap<>();        //<email, username>
        // Build the graph;
        for (List<String> account : accounts) {
            String userName = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }
                name.put(account.get(i), userName);
                
                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));
                graph.get(account.get(i - 1)).add(account.get(i));
            }
        }
        
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();
        // DFS search the graph;
        for (String email : name.keySet()) {
            List<String> list = new LinkedList<>();
            if (visited.add(email)) {
                dfs(graph, email, visited, list);
                Collections.sort(list);
                list.add(0, name.get(email));
                res.add(list);
            }
        }
        
        return res;
    }
    
    public void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> list) {
        list.add(email);
        for (String next : graph.get(email)) {
            if (visited.add(next)) {
                dfs(graph, next, visited, list);
            }
        }
    }
}
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums.length < 3)
            return result;
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; ++i) {
            
            if (i != 0 && nums[i] == nums[i-1])
                continue;
            
            int number = nums[i];
            int low = i + 1;
            int high = nums.length - 1;
            
            while (low < high) {
                
                int total = number + nums[low] + nums[high];
                
                if (total == 0) {
                    
                    List<Integer> list = Arrays.asList(nums[low], number, nums[high]);
                    
                    result.add(list);
                    
                    low++;
                    
                    while (low < high && nums[low] == nums[low-1]) {
                        low++;
                    }
                    
                    high--;
                    
                    while (low < high && nums[high] == nums[high+1]) {
                        high--;
                    }
                    
                } else if (total < 0) {
                    
                    low++;
                    
                } else {
                    
                    high--;
                }
            }
        }
        
        return result;
    
    }
}