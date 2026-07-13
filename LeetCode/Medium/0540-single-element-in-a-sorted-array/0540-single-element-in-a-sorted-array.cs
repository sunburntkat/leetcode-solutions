public class Solution {
    public int SingleNonDuplicate(int[] nums) {
        if(nums.Length==1) return nums[0];
        int l=0;
        int r=nums.Length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid+1]==nums[mid]){
                mid++;
            }
            else if(nums[mid-1]!=nums[mid]){
                return nums[mid];
            }
            if(mid%2==0){
                r=mid-2;
            }
            else{
                l=mid+1;
            }

        }
        return nums[l];
    }
}