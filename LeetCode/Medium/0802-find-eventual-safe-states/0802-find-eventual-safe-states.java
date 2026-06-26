class Solution {
    HashSet<Integer> visited=new HashSet<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result=new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if(dfs(graph,i)){
                result.add(i);
            }
        }
        return result;
    }

    public boolean dfs(int[][] graph, int node) {
        if(graph[node].length==0){
            return true;
        }
        if(visited.contains(node)){
            return false;
        }
        boolean isSafe=true;
        visited.add(node);
        for(int i=0;i<graph[node].length;i++){
            if(!dfs(graph, graph[node][i])) isSafe=false;
        }
        if(isSafe){
            graph[node]=new int[0];
        }
        return isSafe;
    }
}