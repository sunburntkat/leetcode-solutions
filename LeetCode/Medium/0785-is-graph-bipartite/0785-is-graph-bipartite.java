class Solution {
    public boolean isBipartite(int[][] graph) {
        boolean isSetA=true;
        Queue<Integer> q =new LinkedList<>();
        HashSet<Integer> setA=new HashSet<>();
        HashSet<Integer> setB=new HashSet<>();
        HashSet<Integer> visited=new HashSet<>();
        for(int k=0;k<graph.length;k++){
            if(visited.contains(k)) continue;
            q.offer(k);
            visited.add(k);
            System.out.println(k);
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    int node=q.poll();
                    HashSet<Integer> set=isSetA? setA:setB;
                    HashSet<Integer> otherSet=isSetA? setB:setA;
                    visited.add(node);
                    if(otherSet.contains(node)) return false;
                    set.add(node);
                    for(int j=0;j<graph[node].length;j++){
                        if(visited.contains(graph[node][j])) continue;
                        q.offer(graph[node][j]);
                    }
                }
                isSetA=!isSetA;
            }
        }
        return true;
    }
}