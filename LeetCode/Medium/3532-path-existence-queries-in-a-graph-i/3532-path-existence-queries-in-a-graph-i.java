class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        DSU ds = new DSU(n);
        Arrays.sort(nums);
        int l = 0;
        for (int r = 1; r < n; r++) {
            if (Math.abs(nums[r] - nums[l]) <= maxDiff) {
                ds.union(l, r);
            } else if(l<r-1){
                r--;
            }
            l++;
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = ds.findParent(queries[i][0]) == ds.findParent(queries[i][1]);
        }
        return result;
    }
}

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