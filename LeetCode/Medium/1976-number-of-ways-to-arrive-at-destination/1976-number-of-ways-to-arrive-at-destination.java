class Solution {
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n];
        long[] dist = new long[n];
        int[] pathCounts = new int[n];
        pathCounts[0]=1;
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Long.MAX_VALUE;
        }
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]].add(new int[] { roads[i][1], roads[i][2] });
            graph[roads[i][1]].add(new int[] { roads[i][0], roads[i][2] });
        }
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));
        pq.offer(new State(0, 0));
        while (!pq.isEmpty()) {
            State curr = pq.poll();
            if (curr.dist > dist[n - 1]) {
                break;
            }
            if (dist[curr.node] < curr.dist) {
                continue;
            }
            for (int[] nei : graph[curr.node]) {
                long distance = curr.dist + nei[1];
                if (distance < dist[nei[0]]) {
                    dist[nei[0]] = distance;
                    pq.offer(new State(nei[0], distance));
                    pathCounts[nei[0]]=pathCounts[curr.node];
                }else if(distance==dist[nei[0]]){
                    pathCounts[nei[0]]=(int)((pathCounts[nei[0]]+pathCounts[curr.node])%(Math.pow(10, 9) + 7));
                }
            }
        }
        return pathCounts[n-1];
    }
}

class State {
    int node;
    long dist;

    public State(int node, long dist) {
        this.node = node;
        this.dist = dist;
    }
}