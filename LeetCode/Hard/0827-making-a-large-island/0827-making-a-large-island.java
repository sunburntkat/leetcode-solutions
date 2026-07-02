class Solution {
    class DSU {
        int[] parents;
        public int[] sizes;

        public DSU(int n) {
            parents = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }

        public int findParent(int node) {
            if (parents[node] == node) {
                return node;
            }

            return parents[node] = findParent(parents[node]);
        }

        public void union(int n1, int n2) {
            int p1 = findParent(n1);
            int p2 = findParent(n2);

            if (p1 == p2)
                return;

            if (sizes[p1] > sizes[p2]) {
                parents[p2] = p1;
                sizes[p1] += sizes[p2];
            } else {
                parents[p1] = p2;
                sizes[p2] += sizes[p1];
            }
        }

    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;

        DSU ds = new DSU(n * n);
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;
                for (int k = 0; k < 4; k++) {
                    int neiY = i + dy[k];
                    int neiX = j + dx[k];
                    if (neiX < 0 || neiX >= n || neiY < 0 || neiY >= n) {
                        continue;
                    }
                    int neighbour = grid[neiY][neiX];
                    if (neighbour == 0)
                        continue;
                    int neighbourNode = (neiY) * n + (neiX);
                    ds.union(i * n + j, neighbourNode);
                }
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
                    int neighbour = grid[neiY][neiX];
                    if (neighbour == 0)
                        continue;
                    int neighbourNode = (neiY) * n + (neiX);
                    int parent = ds.findParent(neighbourNode);
                    if (visited.contains(parent)) {
                        continue;
                    }
                    visited.add(parent);
                    size += ds.sizes[parent];
                }
                maxSize = Math.max(maxSize, size);
            }
        }
        if (maxSize != 0)
            return maxSize;
        int maxSingle = 0;
        for (int i = 0; i < n*n; i++) {
            maxSingle = Math.max(maxSingle, ds.sizes[i]);
        }
        return maxSingle < n * n ? maxSingle + 1 : maxSingle;
    }
}