class Solution {
    TrieNode root = new TrieNode();
    int k = 0;
    boolean empty = true;

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Integer[] indices = new Integer[queries.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        int[] result = new int[queries.length];
        Arrays.sort(indices, (i, j) -> Integer.compare(queries[i][1], queries[j][1]));
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] > max) {
                max = queries[i][0];
            }
        }
        int maxBitLength = Integer.SIZE - Integer.numberOfLeadingZeros(max);
        for (int i = 0; i < indices.length; i++) {
            buildTrieForQuery(maxBitLength, nums, queries[indices[i]][1]);
            int maxXOR = findMaxXOR(maxBitLength, queries[indices[i]][0]);
            result[indices[i]] = maxXOR;
        }
        return result;
    }

    public void buildTrieForQuery(int maxBitLength, int[] nums, int m) {
        while (k < nums.length && nums[k] <= m) {
            empty = false;
            int bitLength = Integer.SIZE - Integer.numberOfLeadingZeros(nums[k]);
            int extraBitLength = maxBitLength - bitLength;
            TrieNode curr = root;
            for (int i = 0; i < extraBitLength; i++) {
                if (curr.children[0] == null) {
                    curr.children[0] = new TrieNode();
                }
                curr = curr.children[0];
            }
            for (int mask = Integer.highestOneBit(nums[k]); mask > 0; mask >>= 1) {
                int digit = (mask & nums[k]) == 0 ? 0 : 1;
                if (curr.children[digit] == null) {
                    curr.children[digit] = new TrieNode();
                }
                curr = curr.children[digit];
            }
            k++;
        }
    }

    public int findMaxXOR(int maxBitLength, int x) {
        if (empty) {
            return -1;
        }

        int bitLength = Integer.SIZE - Integer.numberOfLeadingZeros(x);
        int extraBitLength = maxBitLength - bitLength;
        TrieNode curr = root;
        int XOR = 0;
        for (int i = 0; i < extraBitLength; i++) {
            if (curr.children[1] != null) {
                XOR = XOR * 2 + 1;
                curr = curr.children[1];
            } else {
                XOR *= 2;
                curr = curr.children[0];
            }
        }
        for (int mask = Integer.highestOneBit(x); mask > 0; mask >>= 1) {
            int digit = (mask & x) == 0 ? 0 : 1;
            if (curr.children[digit == 0 ? 1 : 0] != null) {
                XOR = XOR * 2 + 1;
                curr = curr.children[digit == 0 ? 1 : 0];
            } else {
                XOR *= 2;
                curr = curr.children[digit];
            }
        }
        return XOR;
    }
}

class TrieNode {
    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2];
    }
}