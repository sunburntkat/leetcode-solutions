class Solution {
    public int maxProduct(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            int digit = n % 10;
            freq[digit]++;
            n /= 10;
        }
        int count = 0;
        int x = 0, y = 0;
        for (int i = 9; i >= 1; i--) {
            if (freq[i] == 0) {
                continue;
            } else if (freq[i] == 1) {
                if (count == 0) {
                    x = i;
                    count++;
                } else {
                    y = i;
                    break;
                }
            } else {
                if (count == 0) {
                    x = i;
                    y = i;
                } else {
                    y = i;
                }
                break;
            }

        }
        return x * y;
    }
}