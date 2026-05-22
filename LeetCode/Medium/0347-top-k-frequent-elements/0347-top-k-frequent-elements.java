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
        for (int i = 0; x < k && i < nums.length; i++) {
            if (!(freqArray[nums.length - i] == null)) {
                for (int j = 0; x < k && j < freqArray[nums.length - i].size(); j++, x++) {
                    System.out.println(freqArray[nums.length - i].get(j));
                    result[x] = freqArray[nums.length - i].get(j);
                }
            }
        }
        return result;

    }
}