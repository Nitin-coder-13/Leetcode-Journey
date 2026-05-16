package Graph;

import java.util.*;
// LeetCode quest 216

public class graphValidTree {
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 0; i < edges.length; i++) {
                int a = edges[i][0];
                int b = edges[i][1];
                map.get(a).add(b);
                map.get(b).add(a);

            }
            return BFT(map);
        }

        public boolean BFT(HashMap<Integer, List<Integer>> map) {
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            int count = 0;
            for (int i : map.keySet()) {
                if (visited.contains(i)) continue;
                count++;
                queue.add(i);
                while (!queue.isEmpty()) {
                    int rv = queue.poll();
                    if (visited.contains(rv)) return false; // cycle is present
                    visited.add(rv);
                    for (int nbrs : map.get(rv)) {
                        if (!visited.contains(nbrs)) {
                            queue.add(nbrs);
                        }
                    }
                }
            }
            return count == 1;
        }
    }
}
