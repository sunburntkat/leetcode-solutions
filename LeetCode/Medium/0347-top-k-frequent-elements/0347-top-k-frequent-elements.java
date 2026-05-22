class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        // Step 1: count frequency of each number
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Step 2: fill buckets (index = frequency)
        List<Integer>[] list1 = new List[nums.length + 1];
        for(int i : map.keySet()){
            int freq = map.get(i);
            if(list1[freq] == null) list1[freq] = new ArrayList<>();
            list1[freq].add(i);
        }

        // Step 3: scan from highest freq, collect k elements
        int[] res = new int[k];
        int c = 0;
        for(int i = list1.length-1; i >= 0 && c < k; i--){
            if(list1[i] == null) continue;
            for(int j : list1[i]){
                res[c++] = j;
                if(c == k) break;
            }
        }

        return res;
    }
}