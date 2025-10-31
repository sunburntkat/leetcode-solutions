public class Solution {
    public int[] GetSneakyNumbers(int[] nums) {
        int calcSum=0;
        int calcSquareSum=0;
        int n=nums.Length-2;
        for(int i=0;i<n+2;i++){
            calcSum+=nums[i];
            calcSquareSum+=nums[i]*nums[i];
        }
        int Sum=(n-1)*n/2;
        int SquareSum=n*(n-1)*(2*n-1)/6;
        int dif=calcSum-Sum;
        int squareDiff=calcSquareSum-SquareSum;
        int[] result=new int[2];
        /*diff=x1+x2
        squareDiff=x1^2+x2^2
                  =(diff-x2)^2+x2^2
                  =(diff)^2+x2^2-2(diff)(x2)+x2^2
        squareDiff-diff^2=2x2^2-2diff(x2)
        x2=(2diff+-root((2diff)^2- 4(2)(-(squareDiff-diff^2) ))/2a*/
        result[0]=(int)(2*dif-Math.Sqrt(Math.Pow((2*dif),2)- (4*2*(-squareDiff+Math.Pow(dif,2)))))/(2*2);
        result[1]=(int)(2*dif+Math.Sqrt(Math.Pow((2*dif),2)- (4*2*(-squareDiff+Math.Pow(dif,2)))))/(2*2);
        return result;
    }
}