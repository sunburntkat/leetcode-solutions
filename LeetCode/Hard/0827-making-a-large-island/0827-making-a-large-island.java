class Solution {
    int[] dx = { 0, 0, -1, 1 };
    int[] dy = { -1, 1, 0, 0 };

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        int[][] groups = new int[n][n];
        HashMap<Integer, Integer> sizes = new HashMap<>();

        int groupNo = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 || groups[i][j] != 0)
                    continue;
                groupNo++;
                bfs(grid, groups, sizes, n, j, i, groupNo);
            }
        }
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0)
                    continue;

                int size = 1;
                HashSet<Integer> visited = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int neiY = i + dy[k];
                    int neiX = j + dx[k];
                    if (neiX < 0 || neiX >= n || neiY < 0 || neiY >= n) {
                        continue;
                    }
                    if (grid[neiY][neiX] == 0)
                        continue;
                    groupNo = groups[neiY][neiX];
                    if (visited.contains(groupNo)) {
                        continue;
                    }
                    visited.add(groupNo);
                    size += sizes.get(groupNo);
                }
                maxSize = Math.max(maxSize, size);
            }
        }
        if (maxSize != 0)
            return maxSize;
        
        int maxSingle = 0;
        for (int size:sizes.values()) {
            maxSingle = Math.max(maxSingle, size);
        }
        return maxSingle;
    }

    public void bfs(int[][] grid, int[][] groups, HashMap<Integer, Integer> sizes, int n, int x, int y, int groupNo) {
        Queue<int[]> q = new LinkedList<>();

        int size = 0;
        q.offer(new int[] { x, y });
        while (!q.isEmpty()) {
            int[] node = q.poll();
            int X = node[0];
            int Y = node[1];
            if (groups[Y][X] != 0)
                continue;
            groups[Y][X] = groupNo;
            size++;
            for (int k = 0; k < 4; k++) {
                int neiY = Y + dy[k];
                int neiX = X + dx[k];
                if (neiX < 0 || neiX >= n || neiY < 0 || neiY >= n) {
                    continue;
                }
                if (grid[neiY][neiX] == 0 || groups[neiY][neiX] != 0)
                    continue;
                q.offer(new int[] { neiX, neiY });
            }
        }
        sizes.put(groupNo, size);

    }
}