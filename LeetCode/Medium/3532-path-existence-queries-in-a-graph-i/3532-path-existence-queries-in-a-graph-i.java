class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Arrays.sort(nums);
        int[] groups = new int[n];
        int groupNo = 0;
        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) > maxDiff) {
                groupNo++;
            }
            groups[i] = groupNo;
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = groups[queries[i][0]] == groups[queries[i][1]];
        }
        return result;
    }
}
