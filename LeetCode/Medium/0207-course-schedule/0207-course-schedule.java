class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] tree=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            tree[i]=new ArrayList<>();
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int u=prerequisites[i][1];
            int v=prerequisites[i][0];
            tree[u].add(v);
            indegree[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        int[] result=new int[numCourses];
        int k=0;
        while(!q.isEmpty()){
            int node=q.poll();
            result[k++]=node;
            for(int child:tree[node]){
                indegree[child]--;
                if(indegree[child]==0){
                    q.offer(child);
                }
            }
        }
        if(k!=numCourses){
            return false;
        }
        return true;
    }
}