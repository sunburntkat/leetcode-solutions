public class Solution {
    public int MinCost(string colors, int[] neededTime) {
        int count=0;
        int minTime=neededTime[0];
        for(int i=1;i<colors.Length;i++){
            if(colors[i]==colors[i-1]){
                if(minTime<neededTime[i]){
                    count+=minTime;
                    minTime=neededTime[i];
                }
                else{
                    count+=neededTime[i];
                }
            }
            else{
                minTime=neededTime[i];
            }
        }
        return count;
    }
}