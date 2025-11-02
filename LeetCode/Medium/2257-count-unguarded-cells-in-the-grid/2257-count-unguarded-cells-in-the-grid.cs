public class Solution {
    public int CountUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[,] jail=new int[m,n];
        int count=0;
        for(int i=0;i<guards.Length;i++){
            jail[guards[i][0],guards[i][1]]=2;
        }
        for(int i=0;i<walls.Length;i++){
            jail[walls[i][0],walls[i][1]]=3;
        }
        //iT stands for iTemp
        for(int g=0;g<guards.Length;g++){
            int[] guard=guards[g];

            int i=guard[0]+1;
            int j=guard[1];
            while(i<m && jail[i,j]<=1){
                jail[i,j]=1;
                i++;
            }
            i=guard[0]-1;
            while(i>=0 && jail[i,j]<=1){
                jail[i,j]=1;
                i--;
            }
            
            i=guard[0];
            j=guard[1]+1;
            while(j<n && jail[i,j]<=1){
                jail[i,j]=1;
                j++;
            }
            j=guard[1]-1;
            while(j>=0 && jail[i,j]<=1){
                jail[i,j]=1;
                j--;
            }

        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                count+=jail[i,j]==0?1:0;
            }
        }
        return count;
    }
}