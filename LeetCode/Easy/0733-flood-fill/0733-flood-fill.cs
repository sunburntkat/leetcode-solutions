public class Solution {
    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color){
            return image;
        }
        Queue<(int i,int j)> queue=new();
        (int i,int j)[] neighbours=new (int i,int j)[]{(0,1),(1,0),(-1,0),(0,-1)};
        int original=image[sr][sc];
        queue.Enqueue((sr,sc));
        while(queue.Count!=0){
            var node=queue.Dequeue();
            image[node.i][node.j]=color;
            for(int k=0;k<4;k++){
                var neighbour=(node.i+neighbours[k].i,node.j+neighbours[k].j);
                if(neighbour.Item1>=0&&neighbour.Item2>=0&&neighbour.Item1<image.Length&&neighbour.Item2<image[0].Length&&image[neighbour.Item1][neighbour.Item2]==original){
                    queue.Enqueue(neighbour);
                }
            }
        }
        return image;
    }

}