class Solution {
    public void addNext(PriorityQueue<Integer> pq, int[] lastPos, int[] freq, int curr, int n) {
        int maxTask;
        if (!pq.isEmpty()) {
            maxTask = pq.poll();
        } else {
            return;
        }
        int idleCount;
        if (curr - lastPos[maxTask] > n) {
            lastPos[maxTask] = curr;
            freq[maxTask]--;
        } else {
            addNext(pq, lastPos, freq, curr, n);
        }
        if (freq[maxTask] > 0) {
            pq.add(maxTask);
        }
    }

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int[] lastPos = new int[26];
        int curr = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(freq[b], freq[a]));
        for (int i = 0; i < tasks.length; i++) {
            freq[tasks[i] - 'A']++;
        }
        for (int i = 0; i < lastPos.length; i++) {
            lastPos[i] = -n-1;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                pq.add(i);
            }
        }
        int result = 0;
        while (!pq.isEmpty()) {
            addNext(pq, lastPos, freq, curr, n);
            result++;
            curr++;
        }
        return result;

    }
}