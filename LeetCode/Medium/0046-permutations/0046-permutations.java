import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> prev_elements = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {

            List<Integer> numsList = Arrays.stream(nums)
                                    .boxed()
                                    .collect(Collectors.toList());
            dfs(numsList);
            return results;
        }

        private void dfs(List<Integer> elements) {
            if(elements.size() == 0)
                results.add(new ArrayList<>(prev_elements));

            for (Integer element : elements) {
                List<Integer> next_elements = new ArrayList<>(elements);
                next_elements.remove(element);

                prev_elements.add(element);
                dfs(next_elements);
                prev_elements.remove(prev_elements.size()-1);
            }
        }
    }