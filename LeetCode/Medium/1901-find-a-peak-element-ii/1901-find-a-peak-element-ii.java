class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int l = 0;
        int r = n - 1;
        int mid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int row = -1;
            int max = 0;
            for (int i = 0; i < m; i++) {
                if (mat[i][mid] > max) {
                    max = mat[i][mid];
                    row = i;
                }
            }
            if (mat[row][mid] < (mid == n - 1 ? -1 : mat[row][mid + 1])) {
                l = mid + 1;

            } else if (mat[row][mid] < (mid == 0 ? -1 : mat[row][mid - 1])) {
                r = mid;
            } else {
                return new int[] { row, mid };
            }
        }
        return new int[2];
    }
}