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
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(b[1],a[1]));
        for(Map.Entry<Integer,Integer> entry:hash.entrySet()){
            pq.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=pq.poll()[0];
        }
        return result;
        
    }
}