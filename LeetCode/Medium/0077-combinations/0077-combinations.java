class Solution {

        private List<List<Integer>> results = new ArrayList<>();
        private int inputN;
        public List<List<Integer>> combine(int n, int k) {
            inputN = n;

            dfs(new ArrayList<>(), 1, k);
            return results;
        }

        private void dfs(List<Integer> elements, int start, int k) {

            if(k == 0){
                results.add(new ArrayList<>(elements));
                return;
            }

            for(int i = start ; i <= inputN; i++) {
                elements.add(i);
                dfs(elements, i+1, k-1);
                elements.remove(elements.size()-1);
            }
        }

    }