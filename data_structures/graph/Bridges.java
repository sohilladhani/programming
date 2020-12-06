/* Program to find bridges in an unweighted graph */

import java.util.*;

class Bridges {

    class Edge {
        int src; int dest;
        public Edge(int src, int dest) {
            this.src = src; this.dest = dest;
        }
    }

    public Map<Integer, List<Integer>> getAdjList(List<int[]> edges) {
        // edges are of the pattern [u, v]
        // u - src node, v - dest node
        Map<Integer, List<Integer>> adj = new HashMap<>();
        List<Integer> list = null;
        for(int[] edge: edges) {
            adj.put(edge[0], new ArrayList<>());
            adj.put(edge[1], new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
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

    int id = 0;
    int[] ids = null;
    int[] lows = null;
    boolean[] visited = null;
    boolean[] isArt = null;
    int outEdgeCount = 0;
    public List<Edge> findArticulationPoints(Map<Integer, List<Integer>> adj) {
        int n = adj.size();
        List<Edge> bridges = new ArrayList<>();
        ids = new int[n];
        lows = new int[n];
        visited = new boolean[n];
        isArt = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(visited[i] == true) continue;
            outEdgeCount = 0;
            dfsArt(i, i, -1, bridges, adj);
            isArt[i] = (outEdgeCount > 1);
        }
        
        System.out.println("Articulation points:");
        for(int i = 0; i < n; i++) {
            if(isArt[i] == true) {
                System.out.printf("%d, ", i);
            }
        }
        System.out.println();

        return bridges;
    }

    private void dfsArt(int root, int at, int parent, List<Edge> bridges,
                     Map<Integer, List<Integer>> adj) {
        if(parent == root) outEdgeCount++;
        visited[at] = true;
        id = id + 1;
        lows[at] = ids[at] = id;

        /* for each adjacent node (child) of at node */
        for(int to: adj.get(at)) {
            if(to == parent) continue; // undirected graph
            // if the destination node is not visited
            if(visited[to] == false) {
                //forward edge - the 'to' is yet to be visited
                dfsArt(root, to, at, bridges, adj);
                //callback from DFS to parent
                //update low link value of parent if the child has lower low
                //link value
                lows[at] = Math.min(lows[at], lows[to]);
                //if id of current node is less than low link of the destination
                //node, it's a bridge
                //Articulation point found via bridge
                if(ids[at] < lows[to]) {
                    isArt[at] = true;
                }
                //Articulation point found via cycle
                if(ids[at] == lows[to]) {
                    isArt[at] = true;
                }
            } else {
                //back edge - edge which has edge to its ancestor
                lows[at] = Math.min(lows[at], ids[to]);
            }
        }
    } 

    public List<Edge> findBridges(Map<Integer, List<Integer>> adj) {
        int n = adj.size();
        List<Edge> bridges = new ArrayList<>();
        ids = new int[n];
        lows = new int[n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(visited[i] == true) continue;
            dfs(i, -1, bridges, adj);
        }
        return bridges;
    }

    private void dfs(int at, int parent, List<Edge> bridges,
                     Map<Integer, List<Integer>> adj) {
        visited[at] = true;
        id = id + 1;
        lows[at] = ids[at] = id;

        /* for each adjacent node (child) of at node */
        for(int to: adj.get(at)) {
            if(to == parent) continue; // undirected graph
            // if the destination node is not visited
            if(visited[to] == false) {
                //forward edge - the 'to' is yet to be visited
                dfs(to, at, bridges, adj);
                //callback from DFS to parent
                //update low link value of parent if the child has lower low
                //link value
                lows[at] = Math.min(lows[at], lows[to]);
                //if id of current node is less than low link of the destination
                //node, it's a bridge
                if(ids[at] < lows[to]) {
                    bridges.add(new Edge(at, to));
                }
            } else {
                //back edge - edge which has edge to its ancestor
                lows[at] = Math.min(lows[at], ids[to]);
            }
        }
    }

    public void printBridges(List<Edge> bridges) {
        for(Edge edge: bridges) {
            System.out.println(edge.src + "-" + edge.dest);
        }
    }

    public static void main(String[] args) {
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[] {0, 1});
        edges.add(new int[] {0, 2});
        edges.add(new int[] {1, 2});
        edges.add(new int[] {2, 3});
        edges.add(new int[] {2, 5});
        edges.add(new int[] {3, 4});
        edges.add(new int[] {5, 6});
        edges.add(new int[] {5, 8});
        edges.add(new int[] {6, 7});
        edges.add(new int[] {7, 8});

        Bridges bridges = new Bridges();
        //bridges.printAdjList(bridges.getAdjList(edges));
        bridges.printBridges(bridges.findBridges(bridges.getAdjList(edges)));
        bridges.findArticulationPoints(bridges.getAdjList(edges));
    }
}
