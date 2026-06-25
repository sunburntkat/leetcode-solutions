class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        int[] inbound = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(v);
            inbound[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inbound[i] == 0) {
                q.offer(i);
            }
        }
        int k = 0;
        int[] result = new int[numCourses];
        while (!q.isEmpty()) {
            int course = q.poll();
            result[k++] = course;
            for (int j = 0; j < graph.getOrDefault(course, Collections.emptyList()).size(); j++) {
                int prerequisite = graph.get(course).get(j);
                inbound[prerequisite]--;
                if (inbound[prerequisite] == 0) {
                    q.offer(prerequisite);
                }
            }
        }
        if (k != numCourses) {
            return new int[0];
        }
        return result;
    }
}