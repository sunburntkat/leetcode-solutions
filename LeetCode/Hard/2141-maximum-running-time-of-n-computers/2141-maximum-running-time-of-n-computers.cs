public class Solution {
    public long MaxRunTime(int n, int[] batteries) {
        long sum=0;
        for(int i=0;i<batteries.Length;i++){
            sum+=batteries[i];
        }
        long l=1;
        long r=sum/n;
        while(l<r){
            long mid=l+(r-l)/2+1;
            long runTime=0;
            for(int i=0;i<batteries.Length;i++){
                runTime+=batteries[i]<mid?batteries[i]:mid;
                // runTime+=Math.Min(batteries[i],mid);
            }
            if(runTime/n>=mid){
                l=mid;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }
}