class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);

        for (int i = 0, j = happiness.length - 1; i < j; i++, j--) {
            int temp = happiness[i];
            happiness[i] = happiness[j];
            happiness[j] = temp;
        }

        long result = 0;
        long n = 0;
        for (int i = 0; i < k; i++) {
            if (happiness[i] <= n) {
                break;
            }
            result += happiness[i] - n++;
        }
        return result;
    }
}