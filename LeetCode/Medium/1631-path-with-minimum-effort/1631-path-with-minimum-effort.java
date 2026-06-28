class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        int[] dy = { 1, -1, 0, 0 };
        int[] dx = { 0, 0, -1, 1 };
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        pq.offer(new int[] { 0, 0, 0 });
        dist[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            if (cell[0] == m - 1 && cell[1] == n - 1) {
                return cell[2];
            }
            for (int i = 0; i < 4; i++) {
                int neiY = cell[0] + dy[i];
                int neiX = cell[1] + dx[i];
                if (neiY < 0 || neiY >= m || neiX < 0 || neiX >= n) {
                    continue;
                }
                int effort = Math.max(cell[2], Math.abs(heights[neiY][neiX] - heights[cell[0]][cell[1]]));
                if (dist[neiY][neiX] <= effort) {
                    continue;
                }
                dist[neiY][neiX] = effort;
                int[] nei = new int[] { neiY, neiX, effort };
                pq.offer(nei);
            }
        }
        return -1;
    }
}