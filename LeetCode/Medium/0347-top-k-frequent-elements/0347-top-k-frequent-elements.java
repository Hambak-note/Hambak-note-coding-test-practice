import java.util.*;


class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            Map<Integer, Integer> numsCountMap = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {

                numsCountMap.put(nums[i], numsCountMap.getOrDefault(nums[i], 0)+1);
            }

            
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                    (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())
            );

            pq.addAll(numsCountMap.entrySet());

            int[] output = new int[k];
            for(int i = 0; i < k; i++) {
                output[i] = pq.poll().getKey();
            }

            return output;
        }
    }