import java.util.ArrayList;
import java.util.List;

class Solution {

        private List<List<Integer>> result = new ArrayList<>();
        private int[] nums;
        public List<List<Integer>> subsets(int[] nums) {

            this.nums = nums;
            dfs(0, new ArrayList<>());

            return result;
        }

        private void dfs(int index, List<Integer> path) {
            result.add(path);

            for(int i = index; i < nums.length; i++) {

                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);
                dfs(i+1, newPath);
            }
        }
    }