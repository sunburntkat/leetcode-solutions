class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length-1;
        boolean[] present=new boolean[n];
        for(int num:nums){
            if(present[num-1]){
                return num;
            }
            present[num-1]=true;
        }
        return 0;
    }
}