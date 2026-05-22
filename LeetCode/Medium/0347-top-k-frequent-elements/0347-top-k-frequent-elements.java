class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                hash.put(nums[i], hash.get(nums[i]) + 1);
            } else {
                hash.put(nums[i], 1);
            }
        }
        List<Integer>[] freqArray=new List[nums.length+1];
        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            if(freqArray[entry.getValue()]==null){
                freqArray[entry.getValue()]=new ArrayList<>();
            }
            freqArray[entry.getValue()].add(entry.getKey());
        }
        int[] result=new int[k];
        int x=0;
        for(int i=0;i<nums.length;i++){
            if(!(freqArray[nums.length-i]==null)){
                for(int j=0;x<k && j<freqArray[nums.length-i].size();j++,x++){
                    System.out.println(freqArray[nums.length-i].get(j));
                    result[x]=freqArray[nums.length-i].get(j);
                }
            }
        }
        return result;
        
    }
}