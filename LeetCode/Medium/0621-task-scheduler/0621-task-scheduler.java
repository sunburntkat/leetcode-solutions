class Solution {
    public void addNext(PriorityQueue<Integer> pq, int[] lastPos, int[] freq, int curr, int n) {
        int maxTask;
        Queue<Integer> queue=new LinkedList<>();
        while (!pq.isEmpty()) {
            maxTask = pq.poll();
            if (curr - lastPos[maxTask] > n) {
                lastPos[maxTask] = curr;
                freq[maxTask]--;
                if (freq[maxTask] > 0) {
                    queue.offer(maxTask);
                }
                break;
            } else {
                queue.offer(maxTask);
            }
        }
        while(!queue.isEmpty()){
            pq.add(queue.poll());
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
            lastPos[i] = -n - 1;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                pq.add(i);
            }
        }
        while (!pq.isEmpty()) {
            addNext(pq, lastPos, freq, curr, n);
            curr++;
        }
        return curr;

    }
}