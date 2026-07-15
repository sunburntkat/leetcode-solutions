class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> remainders=new HashMap<>();
        int sum=0;
        int count=0;
        remainders.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int remainder = ((sum % k) + k) % k;   //to convert negative remainders also
            count+=remainders.getOrDefault(remainder,0);
            remainders.put(remainder,remainders.getOrDefault(remainder,0)+1);
        }
        return count;
    }
}