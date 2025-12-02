public class Solution {
    public int OrangesRotting(int[][] grid) {
        int rows = grid.Length;
        if (rows == 0) return -1;
        int cols = grid[0].Length;

        var q = new Queue<int[]>();
        int fresh = 0;

        // initialize queue with all rotten oranges and count fresh
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) q.Enqueue(new int[] { r, c });
                else if (grid[r][c] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0; // no fresh oranges at all

        int minutes = 0;
        int[][] dirs = new int[][] {
            new int[]{ 1, 0 }, new int[]{ -1, 0 }, new int[]{ 0, 1 }, new int[]{ 0, -1 }
        };

        while (q.Count > 0) {
            int size = q.Count;
            bool anyRottedThisMinute = false;

            for (int i = 0; i < size; i++) {
                var cur = q.Dequeue();
                int r = cur[0], c = cur[1];

                foreach (var d in dirs) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (grid[nr][nc] != 1) continue; // only rot fresh oranges

                    // rot it and enqueue immediately to avoid duplicates
                    grid[nr][nc] = 2;
                    fresh--;
                    q.Enqueue(new int[] { nr, nc });
                    anyRottedThisMinute = true;
                }
            }

            if (anyRottedThisMinute) minutes++;
            if (fresh == 0) return minutes; // early exit
        }

        return -1; // there are still fresh oranges left
    }
}
