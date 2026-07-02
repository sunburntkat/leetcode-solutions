class Solution {
    class DSU {
        int[] parents;
        int[] sizes;

        public DSU(int n) {
            parents = new int[n];
            sizes = new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
                sizes[i]=1;
            }
        }

        public int findParent(int node){
            if(parents[node]==node){
                return node;
            }

            return parents[node]=findParent(parents[node]);
        }

        public void union(int n1, int n2) {
            int p1 = findParent(n1);
            int p2 = findParent(n2);

            if (p1 == p2)
                return;

            if (sizes[p1] > sizes[p1]) {
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
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        DSU ds=new DSU(n);
        for(int i=0;i<n;i++){
            for(int j:adj[i]){
                ds.union(i,j);
            }
        }
        int disjointCount=0;
        for(int i=0;i<n;i++){
            if(ds.findParent(i)==i){
                disjointCount++;
            }
        }
        return n-disjointCount;
    }
}