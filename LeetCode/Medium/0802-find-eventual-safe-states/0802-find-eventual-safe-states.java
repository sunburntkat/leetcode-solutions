class Solution {
    boolean[] visited;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        visited = new boolean[graph.length];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i)) {
                result.add(i);
            }
        }
        return result;
    }

    public boolean dfs(int[][] graph, int node) {
        if (graph[node].length == 0) {
            return true;
        }
        if (visited[node]) {
            return false;
        }
        visited[node] = true;
        for (int i = 0; i < graph[node].length; i++) {
            if (!dfs(graph, graph[node][i])) {
                return false;
            }
        }
        graph[node] = new int[0];
        return true;
    }
}