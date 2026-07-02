class Solution {
    class DSU {
        int[] parents;
        int[] sizes;

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

    public int removeStones(int[][] stones) {
        int n = stones.length;

        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> columns = new HashMap<>();
        DSU ds = new DSU(n);
        for (int i = 0; i < n; i++) {
            int[] stone = stones[i];
            if (rows.containsKey(stone[0])) {
                ds.union(i, rows.get(stone[0]));
            } else {
                rows.put(stone[0], i);
            }
            if (columns.containsKey(stone[1])) {
                ds.union(i, columns.get(stone[1]));
            } else

            {
                columns.put(stone[1], i);
            }

        }
        int disjointCount = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findParent(i) == i) {
                disjointCount++;
            }
        }
        return n - disjointCount;
    }
}