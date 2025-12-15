public class Solution {
    public long GetDescentPeriods(int[] prices) {
        long currPeriodLength=1;
        long result=1;
        for(int i=1;i<prices.Length;i++){
            if(prices[i-1]-prices[i]==1){
                currPeriodLength++;
                result+=currPeriodLength;
            }
            else{
                currPeriodLength=1;
                result+=currPeriodLength;
            }
        }
        return result;
    }
}