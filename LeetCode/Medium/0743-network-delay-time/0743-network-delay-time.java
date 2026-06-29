class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] network=new ArrayList[n+1];
        int[] dist=new int[n+1];
        for(int i=0;i<n+1;i++){
            network[i]=new ArrayList<>();
            dist[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<times.length;i++){
            network[times[i][0]].add(times[i]);
        }
        PriorityQueue<State> pq=new PriorityQueue<>((a,b)->Integer.compare(a.time,b.time));
        pq.offer(new State(k,0));
        dist[k]=0;
        int t=1;
        int time=0;
        while(!pq.isEmpty()){
            State curr=pq.poll();
            int max=-1;
            for(int i=1;i<n+1;i++){
                max=Math.max(dist[i],max);
            }
            if(t==n && curr.time>=max){
                return max;
            }
            for(int[] nei:network[curr.node]){
                if(curr.time+nei[2]>=dist[nei[1]]){
                    continue;
                }
                time=curr.time+nei[2];
                if(dist[nei[1]]==Integer.MAX_VALUE){
                    t++;
                }
                dist[nei[1]]=time;
                pq.offer(new State(nei[1],time));
            }
        }
        return -1;
    }
}
class State{
    int node;
    int time;
    public State(int node,int time){
        this.node=node;
        this.time=time;
    }
}