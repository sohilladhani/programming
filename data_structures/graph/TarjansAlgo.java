/* Implementation of Tarjan's algo for Strongly Connected Component (SCC)
 *
 */

import java.util.*;

class TarjansAlgo {
    public Map<Integer, List<Integer>> getAdjList(List<int[]> edges) {
        // edges are of the pattern [u, v]
        // u - src node, v - dest node
        Map<Integer, List<Integer>> adj = new HashMap<>();
        List<Integer> list = null;
        for(int[] edge: edges) {
            adj.put(edge[0], new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        return adj;
    }

    public void printAdjList(Map<Integer, List<Integer>> adj) {
        for(Map.Entry<Integer, List<Integer>> entry: adj.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for(Integer to: entry.getValue()) {
                System.out.print(to + " -> ");
            }
            System.out.println("NULL");
        }
    }

    int UNVISITED = -1;
    int id = 0;
    int sccCount = 0;
    int[] ids = null;
    int[] lows = null;
    Stack<Integer> invariant = null;
    boolean[] onStack = null;
    
    public int[] findSCCs(Map<Integer, List<Integer>> adj) {
        int n = adj.size();
        ids = new int[n];
        lows = new int[n];
        onStack = new boolean[n];
        invariant = new Stack<>();

        for(int i = 0; i < n; i++) ids[i] = UNVISITED;
        for(int i = 0; i < n; i++) {
            if(ids[i] == UNVISITED) {
                dfs(i, adj);
            }
        }
        return lows;
    }

    private void dfs(int at, Map<Integer, List<Integer>> adj) {
        invariant.push(at);
        onStack[at] = true;
        ids[at] = lows[at] = id++;

        for(int to: adj.get(at)) {
            if(ids[to] == UNVISITED) dfs(to, adj);
            if(onStack[to] == true) {
                lows[at] = Math.min(lows[at], lows[to]);
            }
        }

        /* After visiting all the neighboring nodes of 'at',
         * if we're at the start of SCC (cycle), empty the set
         * until we're at the back of SCC
         */
        if(ids[at] == lows[at]) {
            //ids[at] == lows[at] means start of SCC (cycle)
            for(int node = invariant.pop(); ; node = invariant.pop()) {
                onStack[node] = false;
                lows[node] = ids[at];
                if(node == at) break;
            }
            sccCount++;
        }
    }
    
    public static void main(String[] args) {
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[] {0, 1});
        edges.add(new int[] {1, 2});
        edges.add(new int[] {2, 0});
        edges.add(new int[] {3, 4});
        edges.add(new int[] {3, 7});
        edges.add(new int[] {4, 5});
        edges.add(new int[] {5, 6});
        edges.add(new int[] {5, 0});
        edges.add(new int[] {6, 0});
        edges.add(new int[] {6, 2});
        edges.add(new int[] {6, 4});
        edges.add(new int[] {7, 3});
        edges.add(new int[] {7, 5});

        TarjansAlgo ta = new TarjansAlgo();
        ta.printAdjList(ta.getAdjList(edges));
        int[] lows = ta.findSCCs(ta.getAdjList(edges));
        System.out.println(ta.sccCount);
        for(int i = 0; i < lows.length; i++) {
            System.out.printf("%d, ", lows[i]);
        }
        System.out.println();
    }
}
