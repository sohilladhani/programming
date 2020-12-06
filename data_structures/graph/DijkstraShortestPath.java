/* Program to find shortest path in a directed graph using Dijkstra's algorithm
 *
*/
import java.util.*;

class Dijkstra {

    class Edge implements Comparable<Edge> {
        int dest; int weight;
        public Edge(int dest, int weight) {
            this.dest = dest; this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }
    public Map<Integer, List<Edge>> getAdjList(List<int[]> weightedEdges) {
        // weghtedEdges are of the pattern [u, v, w] 
        // u - src node, v - dest node, w = weight between nodes
        Map<Integer, List<Edge>> adj = new HashMap<>();
        List<Edge> list = null;
        for(int[] weightedEdge: weightedEdges) {
            adj.put(weightedEdge[0], new ArrayList<>());
        }
        for(int[] weightedEdge: weightedEdges) {
            list = adj.get(weightedEdge[0]);
            list.add(new Edge(weightedEdge[1], weightedEdge[2]));
            adj.put(weightedEdge[0], list);
        }
        return adj;
    }

    public void printAdjList(Map<Integer, List<Edge>> adj) {
        for(Map.Entry<Integer, List<Edge>> entry: adj.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for(Edge edge: entry.getValue()) {
                System.out.print("(" + edge.dest + ", " + edge.weight + ") -> ");
            }
            System.out.println("NULL");
        }
    }

    //Eager implementation to update the value in key-value pair of the 
    //priority queue used to store (egde.dest, edge.weight) pair using 
    //an indexed priority queue. we used decreaseKey operation to 
    //decrease the value (i.e. edge.weight) of the PQ pair
    // Check https://algs4.cs.princeton.edu/24pq/IndexMinPQ.java.html
    public List<int[]> shortestPathEager(Map<Integer, List<Edge>> adj, int src, int n) {
        // TODO: Implement using IPQ
        List<int[]> res = new ArrayList<>();

        return res;
    }

    public List<int[]> shortestPathLazy(Map<Integer, List<Edge>> adj, int src, int n) {
        int[] shortestDist = new int[n];
        int[] shortestPath = new int[n];    //to reconstruct the shortest path
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> minHeap = new PriorityQueue<Edge>();
        List<int[]> res = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            shortestDist[i] = Integer.MAX_VALUE;
            shortestPath[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        shortestDist[src] = 0;
        visited[src] = true;
        minHeap.offer(new Edge(src, 0));

        while(!minHeap.isEmpty()) {
            Edge u = minHeap.poll();
            visited[u.dest] = true;
            if(shortestDist[u.dest] < u.weight) continue;
            if(adj.get(u.dest) == null) continue;
            for(Edge v: adj.get(u.dest)) {
                if(visited[v.dest] == true) continue;
                int newDist = shortestDist[u.dest] + v.weight;
                if(newDist < shortestDist[v.dest]) {
                    shortestDist[v.dest] = newDist;
                    minHeap.offer(new Edge(v.dest, newDist));
                    shortestPath[v.dest] = u.dest;
                }
            }
        }
        res.add(shortestDist);
        res.add(shortestPath);
        return res;
    }

    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == Integer.MAX_VALUE) {
                System.out.print("+INF");
            } else if(arr[i] == Integer.MIN_VALUE) {
                System.out.print("-INF");
            } else {
                System.out.print(arr[i]);
            }
            if(i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void showShortestPath(int[] shortestPath, int[] shortestDist, 
                                        int src, int dest) {
        System.out.printf("Path from %d to %d\n", src, dest);
        if(shortestDist[dest] == Integer.MAX_VALUE) {
            System.out.printf("No path from %d to %d\n", src, dest);
        }
        List<Integer> path = new ArrayList<>();
        
        int i = dest;
        while(i != Integer.MAX_VALUE) {
            path.add(0, i);
            i = shortestPath[i];
        }

        for(int node: path) {
            System.out.printf("%d -> ", node);
        }
        System.out.println("STOP");
    }

    public static void main(String[] args) {
        List<int[]> weightedEdges = new ArrayList<>();
        weightedEdges.add(new int[] {0, 1, 5});
        weightedEdges.add(new int[] {0, 2, 1});
        weightedEdges.add(new int[] {1, 2, 2});
        weightedEdges.add(new int[] {1, 3, 3});
        weightedEdges.add(new int[] {1, 4, 20});
        weightedEdges.add(new int[] {2, 1, 3});
        weightedEdges.add(new int[] {2, 4, 12});
        weightedEdges.add(new int[] {3, 2, 3});
        weightedEdges.add(new int[] {3, 4, 2});
        weightedEdges.add(new int[] {3, 5, 6});
        weightedEdges.add(new int[] {4, 5, 1});

        Set<Integer> nodes = new HashSet<>();
        for(int[] weightedEdge: weightedEdges) {
            nodes.add(weightedEdge[0]);
            nodes.add(weightedEdge[1]);
        }
        Dijkstra dijkstra = new Dijkstra();
        Map<Integer, List<Edge>> adj = dijkstra.getAdjList(weightedEdges);
        dijkstra.printAdjList(adj);
        int[] shortestPath; int[] shortestDist;
        for(int src: nodes) {
            System.out.println("Distance array for src: " + src);
            shortestDist = dijkstra.shortestPathLazy(adj, src,
                    nodes.size()).get(0);
            shortestPath = dijkstra.shortestPathLazy(adj, src,
                    nodes.size()).get(1);
            printArray(shortestDist);
            for(int dest: nodes) {
                if(src != dest) {
                    showShortestPath(shortestPath, shortestDist, src, dest);
                }
            }
        }
    }
}
