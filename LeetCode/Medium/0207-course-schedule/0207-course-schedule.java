class Solution {

        private Set<Integer> traced = new HashSet<>();
        private Set<Integer> visited = new HashSet<>();

        public boolean canFinish(int numCourses, int[][] prerequisites) {

            Map<Integer, List<Integer>> graph = makeGraph(prerequisites);
            for (Integer key : graph.keySet()) {
                for (Integer destination : graph.get(key)) {
                    if(!dfs(destination, graph)) return false;
                }
            }
            return true;
        }

        private Map<Integer, List<Integer>> makeGraph(int[][] prerequisites) {

            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (int[] prerequisite : prerequisites) {
                int start = prerequisite[0];
                int dest = prerequisite[1];
                if(graph.containsKey(start)) {
                    graph.get(start).add(dest);
                    continue;
                }
                List<Integer> destinations = new ArrayList<>();
                destinations.add(dest);
                graph.put(start, destinations);
            }

            return graph;
        }

        private boolean dfs(int index, Map<Integer, List<Integer>> graph) {
            if(traced.contains(index)) return false;
            if(visited.contains(index)) return true;

            traced.add(index);

            if(!graph.containsKey(index)) {
                traced.remove(index);
                return true;
            }
            List<Integer> destinations = graph.get(index);
            for (Integer destination : destinations) {
                if(!dfs(destination, graph)) return false;
            }

            traced.remove(index);
            visited.add(index);

            return true;
        }

    }