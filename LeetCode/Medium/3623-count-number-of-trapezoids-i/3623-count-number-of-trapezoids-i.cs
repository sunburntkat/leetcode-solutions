public class Solution {
    public int CountTrapezoids(int[][] points) {
        var hash=new Dictionary<int,long>();
        for(int i=0;i<points.Length;i++){
            if(hash.ContainsKey(points[i][1])){
                hash[points[i][1]]++;
            }
            else{
                hash[points[i][1]]=1;
            }
        }
        var list=new List<long>();
        foreach(var kvp in hash){
            list.Add((kvp.Value*(kvp.Value-1)/2)%1000000007);
        }
        long sum=0,sumSquares=0;
        
        for(int i=0;i<list.Count;i++){
            sum+=list[i]%1000000007;
            sumSquares+=(list[i]*(list[i]%1000000007));
            sum%=1000000007;
            sumSquares%=1000000007;
        }
        return (int)((((sum*sum)%1000000007-sumSquares+1000000007)*500000004)%1000000007) ;
    }
}