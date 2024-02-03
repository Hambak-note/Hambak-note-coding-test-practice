class Solution {

        private List<String> result = new ArrayList<>();

        public List<String> findItinerary(List<List<String>> tickets) {


            sortTicketsInDictionaryOrder(tickets);
            Map<String, Queue<String>> graph = makeTicketsGraph(tickets);
            dfs("JFK", graph);

            Collections.reverse(result);

            return result;
        }

        private void dfs(String from, Map<String, Queue<String>> graph) {
            Queue<String> toStack = graph.get(from);
            while( toStack != null && !toStack.isEmpty() ) {
                String to = toStack.poll();
                dfs(to, graph);
            }
            result.add(from);

        }

        private Map<String, Queue<String>> makeTicketsGraph(List<List<String>> tickets) {

            Map<String, Queue<String>> graph = new HashMap<>();
            for (List<String> ticket : tickets) {
                String from = ticket.get(0);
                String to = ticket.get(1);
                if(!graph.containsKey(from)) {
                    Queue<String> addQueue = new LinkedList<>();
                    addQueue.offer(to);
                    graph.put(from, addQueue);
                }
                else {
                    graph.get(from).offer(to);
                }
            }

            return graph;
        }

        private void sortTicketsInDictionaryOrder(List<List<String>> tickets) {

            Collections.sort(tickets, new Comparator<List<String>>() {
                @Override
                public int compare(List<String> t1, List<String> t2) {
                    int result = t1.get(0).compareTo(t2.get(0));
                    if(result == 0) {
                        result = t1.get(1).compareTo(t2.get(1));
                    }
                    return result;
                }
            });
        }

    }