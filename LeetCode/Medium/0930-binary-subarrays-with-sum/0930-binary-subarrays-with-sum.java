class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();
        int sum = 0;
        int count = 0;
        prefixSum.put(0, 1);
        for (int num : nums) {
            sum += num;
            count += prefixSum.getOrDefault(sum - goal,0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}