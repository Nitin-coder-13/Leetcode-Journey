package Graph;

import java.util.*;

// LeetCode 785
public class Bipartite {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            HashMap<Integer, Integer> visited = new HashMap<>();
            Queue<BipartitePair> queue = new LinkedList<>();
            for (int src = 0; src < graph.length; src++) {
                if (visited.containsKey(src)) {
                    continue;
                }
                queue.add(new BipartitePair(src, 0));
                while (!queue.isEmpty()) {
                    BipartitePair remove = queue.poll();
                    if (visited.containsKey(remove.vertex)) {
                        if (visited.get(remove.vertex) != remove.distance) {
                            return false;
                        } else {
                            continue;
                        }
                    }
                    visited.put(remove.vertex, remove.distance);
                    for (int nbrs : graph[remove.vertex]) {
                        if (!visited.containsKey(nbrs)) {
                            BipartitePair np = new BipartitePair(nbrs, remove.distance + 1);
                            queue.add(np);
                        }
                    }

                }
            }
            return true;
        }

        class BipartitePair {
            int vertex;
            int distance;

            public BipartitePair(int vertex, int distance) {
                this.vertex = vertex;
                this.distance = distance;
            }
        }
    }
}
