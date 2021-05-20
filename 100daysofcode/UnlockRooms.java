/* https://binarysearch.com/problems/Unlock-Rooms */

import java.util.*;

class Solution {
    int connected = 0;
    boolean[] visited = null;
    public boolean solve(int[][] rooms) {
        //question is about if we can reach other nodes from
        // the given node (first room) in the graph
        if(rooms.length == 0) return false;
        visited = new boolean[rooms.length];
        visited[0] = true;
        connected++;
        for(int key: rooms[0]) {
            dfs(rooms, key);
        }
        return connected == rooms.length;
    }

    private void dfs(int[][] rooms, int key) {
        if(visited[key] == true) return;
        visited[key] = true;
        connected++;
        for(int currKey: rooms[key]) {
            dfs(rooms, currKey);
        }
    }
}
