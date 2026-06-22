class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        int maxBitLength = Integer.SIZE - Integer.numberOfLeadingZeros(max);
        TrieNode trie = buildTrie(nums, maxBitLength);
        int maxXOR = 0;
        for (int i = 1; i < nums.length; i++) {
            TrieNode curr = trie;
            int bitLength = Integer.SIZE - Integer.numberOfLeadingZeros(nums[i]);
            int extraBitLength = maxBitLength - bitLength;
            int XOR = 0;
            for (int j = 0; j < extraBitLength; j++) {
                if (curr.children[1] != null) {
                    XOR = XOR * 2 + 1;
                    curr = curr.children[1];
                } else {
                    XOR*=2;
                    curr = curr.children[0];
                }
            }
            for (int mask = Integer.highestOneBit(nums[i]); mask > 0; mask >>= 1) {
                int digit = ((nums[i] & mask) != 0) ? 1 : 0;
                if (curr.children[digit == 0 ? 1 : 0] != null) {
                    XOR = XOR * 2 + 1;
                    curr = curr.children[digit == 0 ? 1 : 0];
                } else {
                    XOR *= 2;
                    curr = curr.children[digit];
                }
            }

            if (XOR > maxXOR) {
                maxXOR = XOR;
            }
        }
        return maxXOR;
    }

    public TrieNode buildTrie(int[] nums, int maxBitLength) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < nums.length; i++) {
            TrieNode curr = root;
            int bitLength = Integer.SIZE - Integer.numberOfLeadingZeros(nums[i]);
            int extraBitLength = maxBitLength - bitLength;
            for (int j = 0; j < extraBitLength; j++) {
                if (curr.children[0] == null) {
                    curr.children[0] = new TrieNode();
                }
                curr = curr.children[0];
            }
            for (int mask = Integer.highestOneBit(nums[i]); mask > 0; mask >>= 1) {
                int digit = ((nums[i] & mask) != 0) ? 1 : 0;
                if (curr.children[digit] == null) {
                    curr.children[digit] = new TrieNode();
                }
                curr = curr.children[digit];
            }

            curr.endWord = true;
        }
        return root;
    }
}

class TrieNode {
    public boolean endWord;
    public TrieNode[] children;

    public TrieNode() {
        children = new TrieNode[2];
    }
}