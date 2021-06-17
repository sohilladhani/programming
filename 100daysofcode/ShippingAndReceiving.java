/* https://binarysearch.com/problems/Shipping-and-Receiving */

/* Source: https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/ */
import java.util.*;

class Solution {
    public int solve(int[][] ports, int[][] shipments) {
        int[][] graph = new int[ports.length][ports.length];
        int[][] dist = new int[ports.length][ports.length];
        for(int i = 0; i < graph.length; i++) {
            for(int j = 0; j < graph[i].length; j++) {
                if(i != j) graph[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0; i < ports.length; i++) {
            for(int j = 0; j < ports[i].length; j++) {
                graph[i][ports[i][j]] = 1;
            }
        }

        for (int i = 0; i < ports.length; i++) {
            for (int j = 0; j < ports.length; j++) {
                dist[i][j] = graph[i][j];
            }
        }  

        for (int k = 0; k < dist.length; k++)
        {
            // Pick all vertices as source one by one
            for (int i = 0; i < dist.length; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (int j = 0; j < dist.length; j++)
                {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] != Integer.MAX_VALUE && 
                        dist[k][j] != Integer.MAX_VALUE && 
                        dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
        int ans = 0;
        for(int i = 0; i < shipments.length; i++) {
            if(dist[shipments[i][0]][shipments[i][1]] != Integer.MAX_VALUE)
                ans += dist[shipments[i][0]][shipments[i][1]];
        }
        return ans;
    }
}
