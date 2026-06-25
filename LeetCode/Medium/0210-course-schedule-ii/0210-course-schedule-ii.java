class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i]=new ArrayList<>();
        }
        int[] inbound = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            graph[u].add(v);
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
            for (int j = 0; j < graph[course].size(); j++) {
                int prerequisite = graph[course].get(j);
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