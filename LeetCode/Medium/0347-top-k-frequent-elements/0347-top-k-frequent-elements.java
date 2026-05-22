class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] freqArray = new List[nums.length + 1];
        for (int freq : hash.keySet()) {
            if (freqArray[hash.get(freq)] == null) {
                freqArray[hash.get(freq)] = new ArrayList<>();
            }
            freqArray[hash.get(freq)].add(freq);
        }

        int[] result = new int[k];
        int x = 0;
        for (int i = nums.length; x < k && i>=0 ; i--) {
            if (!(freqArray[i] == null)) {
                for (int j = 0; x < k && j < freqArray[i].size(); j++, x++) {
                    System.out.println(freqArray[i].get(j));
                    result[x] = freqArray[i].get(j);
                }
            }
        }
        return result;

    }
}