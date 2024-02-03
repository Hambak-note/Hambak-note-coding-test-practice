

import java.util.ArrayList;
import java.util.List;

class Solution {

        private List<List<Integer>> result = new ArrayList<>();
        private int[] candidates;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            this.candidates = candidates;

            dfs(target, 0, new ArrayList<>());
            return result;
        }

        private void dfs(int cSum, int index, List<Integer> path) {

            if(cSum < 0) return;
            if(cSum == 0) {
                result.add(path);
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                List<Integer> curList = new ArrayList<>(path);
                curList.add(candidates[i]);
                dfs(cSum - candidates[i], i, curList);
            }
        }
    }
