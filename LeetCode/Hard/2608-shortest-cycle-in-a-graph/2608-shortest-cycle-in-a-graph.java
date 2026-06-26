class Solution {
    int shortest = Integer.MAX_VALUE;

    public int findShortestCycle(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]].add(edges[i][1]);
            graph[edges[i][1]].add(edges[i][0]);
        }

        for (int i = 0; i < n; i++) {
            shortest = Math.min(shortest, bfs(i, graph, n));
        }
        if(shortest==Integer.MAX_VALUE){
            return -1;
        }
        return shortest;
    }

    public int bfs(int i, List<Integer>[] graph, int n) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] parents = new int[n];
        int[] distance = new int[n];
        int shortest = Integer.MAX_VALUE;

        q.offer(i);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int j = 0; j < size; j++) {
                int node = q.poll();
                for (int nei : graph[node]) {
                    if (parents[node] == nei)
                        continue;
                    if (visited[nei]) {
                        shortest= Math.min(shortest,distance[node]+distance[nei]+1);
                        continue;
                    }
                    distance[nei]=distance[node]+1;
                    visited[nei]=true;
                    parents[nei] = node;
                    q.offer(nei);
                }
            }
        }
        return shortest;
    }
}