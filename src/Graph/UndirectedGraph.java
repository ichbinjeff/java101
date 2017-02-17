package Graph;

import java.util.*;

/**
 * Created by jli on 11/8/15.
 */
public class UndirectedGraph {
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        int m = nodes.size();
        Map<UndirectedGraphNode, Boolean> visited = new HashMap<UndirectedGraphNode, Boolean>();
        // initialize
        for (UndirectedGraphNode node : nodes) {
            visited.put(node, false);
        }

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (UndirectedGraphNode node : nodes) {
            if (visited.get(node) == false) {
                bfs(node, visited, result);
            }
        }
        return null;
    }

    public void bfs(UndirectedGraphNode node, Map<UndirectedGraphNode, Boolean> visited, List<List<Integer>> result) {
        List<Integer> row = new ArrayList<Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        visited.put(node, true);
        queue.offer(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode u = queue.poll();
            row.add(u.label);

            for (UndirectedGraphNode v : u.neighbors) {
                if (visited.get(v) == false) {
                    visited.put(v, true);
                    queue.offer(v);
                }
            }
        }

        Collections.sort(row);
        result.add(row);
    }
}
