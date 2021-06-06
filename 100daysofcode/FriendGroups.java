/* https://binarysearch.com/problems/Friend-Groups */

class Solution {
    boolean[] visited;
    public int solve(int[][] friends) {
        if(friends.length <= 1) return friends.length;
        int connected = 0;
        visited = new boolean[friends.length];
        for(int i = 0; i < friends.length; i++) {
            if(visited[i] == false) {
                connected++;
                for(int friend: friends[i]) {
                    dfs(friends, friend);
                }
            }
        }
        return connected;
    }

    private void dfs(int[][] friends, int friend) {
        if(visited[friend] == true) return;
        visited[friend] = true;
        for(int friendOfFriend: friends[friend]) {
            dfs(friends, friendOfFriend);
        }
    }
}
