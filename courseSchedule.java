public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // key - value : node - neighbors
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // map the node and the indegree
        Map<Integer, Integer> map = new HashMap<>();
        // count the indegree and construct graph
        for (int[] pair : prerequisites) {
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], 1);
            } else {
                map.put(pair[1], 1 + map.get(pair[1]));
            }
            if (!graph.containsKey(pair[0])) {
                graph.put(pair[0], new ArrayList<>(Arrays.asList(pair[1])));
            } else {
                graph.get(pair[0]).add(pair[1]);
            }
        }
        // push node with 0 indegree to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!map.containsKey(i)) {
                queue.offer(i);
            }
        }
        // count teh number of nodes that have been popped out from queue
        int count = 0;
        while (!queue.isEmpty()) {
            count++;
            Integer cur = queue.poll();
            // get the list of neighbors of current node
            List<Integer> list = graph.get(cur);
            if (list != null) {
                for (Integer i : list) {
                    if (map.containsKey(i)) {
                        if (map.get(i) == 1) {
                            // add the neighbor with 0 indegree to queue
                            queue.offer(i);
                        } else {
                            // update the indegree to be indegree - 1
                            map.put(i, map.get(i) - 1);
                        }
                    }
                }
            }
        }
        // if the count is smaller than numCourses, it means that there are number of courses that cannot
        // be scheduled in anyway. If the count is equal to the numCourses, then all courses can be scheduled
        return count == numCourses;
    }
}