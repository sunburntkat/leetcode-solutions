class Solution {
    public int findMaximumXOR(int[] nums) {
        int max=0;
        for(int num:nums){
            if(num>max){
                max=num;
            }
        }
        
        int mask=Integer.highestOneBit(max);
        int result=0, prefixMask=0;
        while(mask>0){
            prefixMask|=mask;
            int candidate=result|mask;
            HashSet<Integer> set=new HashSet<>();
            for(int num: nums){
                int prefix=prefixMask & num;
                set.add(prefix);
                if(set.contains(prefix^candidate)){
                    result=candidate;
                    break;
                }
            }
            mask>>=1;
        }
        return result;
    }
}

