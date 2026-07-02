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

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> hash = new HashMap<>();
        int n = accounts.size();
        DSU ds = new DSU(n);
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                if (hash.containsKey(account.get(j))) {
                    ds.union(i, hash.get(account.get(j)));
                    // break;
                } else {
                    hash.put(account.get(j), i);
                }
            }
        }
        List<String>[] resultArray = new ArrayList[n];
        for (Map.Entry<String, Integer> entry : hash.entrySet()) {
            int nameNode = ds.findParent(entry.getValue());
            if (resultArray[nameNode] == null) {
                resultArray[nameNode] = new ArrayList<>();
            }
            resultArray[nameNode].add(entry.getKey());
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<String> mailList = resultArray[i];
            if(mailList==null) continue;
            Collections.sort(mailList);
            mailList.add(0, accounts.get(i).get(0));
            result.add(mailList);
        }
        return result;
    }
}