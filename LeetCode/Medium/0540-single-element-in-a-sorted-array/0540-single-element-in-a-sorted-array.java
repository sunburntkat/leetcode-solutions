class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int l=0;
        int r=nums.length-1;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]==nums[mid+1]){
                if(mid%2==0){
                    l=mid+2;
                }
                else{
                    r=mid-1;
                }
            }
            else if(nums[mid]==nums[mid-1]){
                if(mid%2==0){
                    r=mid;
                }
                else{
                    l=mid+1;
                }
            }
            else{
                return nums[mid];
            }
        }
        return nums[l];
    }
}