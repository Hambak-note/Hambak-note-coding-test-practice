import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

        private Set<Integer> minsu = new HashSet<>();
        private Map<Integer, Integer> brother = new HashMap<>();


        public int solution(int[] topping) {
            int answer = 0;


            initBrotherSet(topping);
            answer = doDivideFair(topping);

            return answer;
        }

        private void initBrotherSet(int[] topping) {
            for (int t : topping) {
                brother.put(t, brother.getOrDefault(t, 0) + 1);
            }
        }

        private int doDivideFair(int[] topping) {

            int count = 0;

            for (int t : topping) {
                minsu.add(t);
                if(brother.containsKey(t)) {
                    int number = brother.get(t)-1;

                    if(number == 0) brother.remove(t);
                    else brother.put(t, number);
                }

                if(minsu.size() == brother.size()) count++;
            }

            return count;
        }
    }