class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int card : hand) {
            freq.put(card, freq.getOrDefault(card,0) + 1);
        }
        int[][] freqArray = new int[freq.size()][];
        int i = 0;
        for (int key : freq.keySet()) {
            freqArray[i++] = new int[] { key, freq.get(key) };
        }
        Arrays.sort(freqArray, (a, b) -> Integer.compare(a[0], b[0]));
        int p = 0;
        int n = hand.length;
        for (int j = 0; j < n; j += groupSize) {
            int l = p;
            freqArray[p][1]--;
            p++;
            for (int k = 1; k < groupSize; k++) {
                if(p>=freqArray.length || freqArray[p][1] == 0 ||freqArray[p][0]!=freqArray[p-1][0]+1) {
                    return false;
                }
                freqArray[p][1]--;
                p++;
            }
            p=l;
            while (p<freqArray.length && freqArray[p][1] == 0) {
                p++;
            }
        }
        return true;
    }
}