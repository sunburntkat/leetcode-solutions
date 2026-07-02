class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] parents=new int[n];
        int[] sizes=new int[n];

        for(int i=0;i<n;i++){
            parents[i]=i;
            sizes[i]=1;
        }
        int excessEdges=0;
        for(int i=0;i<connections.length;i++){
            int[] edge=connections[i];
            
            if(!union(parents, sizes,edge[0],edge[1])){
                excessEdges++;
            }
        }
        int noOfGroups=0;
        for(int i=0;i<n;i++){
            if(parents[i]==i){
                noOfGroups++;
            }
        }
        if(excessEdges<noOfGroups-1){
            return -1;
        }
        return noOfGroups-1;
    }

    public int findParent(int[] parents, int node){
        if(parents[node]==node){
            return node;
        }

        parents[node]=findParent(parents,parents[node]);
        
        return parents[node];
    }

    public boolean union(int[] parents, int[] sizes, int node1, int node2){
        int parent1=findParent(parents,node1);
        int parent2=findParent(parents,node2);

        if(parent1==parent2) return false;

        if(sizes[parent1]>sizes[parent2]){
            parents[parent1]=parent2;
            sizes[parent1]+=sizes[parent2];
        }else{
            parents[parent2]=parent1;
            sizes[parent2]+=sizes[parent1];
        }
        return true;
    }
    
}
