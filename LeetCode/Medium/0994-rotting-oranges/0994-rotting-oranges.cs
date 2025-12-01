public class Solution {
    public int OrangesRotting(int[][] grid) {
        int minutes=0;
        var frontier=new List<int[]>();
        for(int i=0;i<grid.Length;i++){
            for(int j=0;j<grid[0].Length;j++){
                if(grid[i][j]==2){
                    frontier.Add(new int[]{i,j});
                    grid[i][j]=1;
                }
            }
        }
        while(frontier.Count!=0){
            Console.Write(1);
            bool traversed=false;
            var list=new List<int[]>();
            for(int k=0;k<frontier.Count;k++){
                int i=frontier[k][0];
                int j=frontier[k][1];
                if(i>=grid.Length||i<0||j>=grid[0].Length||j<0){
                    continue;
                }
                if(grid[i][j]==0||grid[i][j]==2){
                    continue;
                }
                Console.Write(3);
                list.Add(new int[]{i+1,j});
                list.Add(new int[]{i-1,j});
                list.Add(new int[]{i,j+1});
                list.Add(new int[]{i,j-1});
                grid[i][j]=2;
                traversed=true;
            }
            frontier=list;
            if(frontier.Count==0){
                minutes--;
                break;
            }
            if(!traversed){
                break;
            }
            Console.Write(frontier.Count);
            minutes++;
        } 
        for(int i=0;i<grid.Length;i++){
            for(int j=0;j<grid[0].Length;j++){
                Console.Write(2);
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return minutes;
    }
}