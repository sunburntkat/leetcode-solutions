class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.timeToWait, b.timeToWait));
        pq.offer(new State(0, 0, 0, grid[0][0]));
        ;

        int n = grid.length;
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        while (!pq.isEmpty()) {
            State node = pq.poll();
            if (node.x == n - 1 && node.y == n - 1)
                return node.timeToWait;
            for (int i = 0; i < 4; i++) {
                int neiX = node.x + dx[i];
                int neiY = node.y + dy[i];
                if (neiX < 0 || neiX >= n || neiY < 0 || neiY >= n) {
                    continue;
                }

                if (visited[neiY][neiX]) {
                    continue;
                }
                visited[neiY][neiX] = true;
                pq.offer(new State(neiX, neiY, node.timeToWait, Math.max(node.timeToWait, grid[neiY][neiX])));
            }
        }
        return -1;

    }
}

class State {
    public int x;
    public int y;
    public int timeWaited;
    public int timeToWait;

    public State(int x, int y, int timeWaited, int timeToWait) {
        this.timeWaited = timeWaited;
        this.timeToWait = timeToWait;
        this.x = x;
        this.y = y;
    }
}