public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<>();
        if (tickets == null || tickets.length == 0) {
            return result;
        }
        
        Map<String, List<String>> graph = new HashMap<>();
        // build graph
        for (String[] str : tickets) {
            String word1 = str[0];
            String word2 = str[1];
            if (!graph.containsKey(word1)) {
                graph.put(word1, new ArrayList<>(Arrays.asList(word2)));
            } else {
                graph.get(word1).add(word2);
            }
            if (!graph.containsKey(word2)) {
                graph.put(word2, new ArrayList<>());
            }
        }
        // sort the neighbor list
        for (String str : graph.keySet()) {
            List<String> list = graph.get(str);
            Collections.sort(list);
        }
        // use dfs to traverse the graph
        dfs("JFK", graph, result);
        Collections.reverse(result);
        return result;
    }
    
    public void dfs(String cur, Map<String, List<String>> graph, List<String> list) {
        while (graph.containsKey(cur) && !graph.get(cur).isEmpty()) {
            dfs(graph.get(cur).remove(0), graph, list);
        }
        list.add(cur);
    }
}