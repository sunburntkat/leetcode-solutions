class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] discovered = new int[n];
        int[] low = new int[n]; //low[u]=smallest discovery time node reachable by u (time is noted down)
        boolean[] visited = new boolean[n];
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            low[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < connections.size(); i++) {
            graph[connections.get(i).get(0)].add(connections.get(i).get(1));
            graph[connections.get(i).get(1)].add(connections.get(i).get(0));
        }
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, graph, -1,discovered, low, visited, 0, 0);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer>[] graph,int prev, int[] discovered, int[] low, boolean[] visited,
            int node, int t) {
        visited[node] = true;
        discovered[node] = t;
        low[node] = t;
        for (int nei : graph[node]) {
            if(nei==prev) continue;
            if (visited[nei]) {
                low[node] = Math.min(low[node], discovered[nei]);
                continue;
            }
            dfs(result, graph,node, discovered, low, visited, nei, t + 1);
            low[node]=Math.min(low[node],low[nei]);
            if (low[nei] > discovered[node]) {
                result.add(new ArrayList<>(List.of(node, nei)));
            }
        }
    }
}
