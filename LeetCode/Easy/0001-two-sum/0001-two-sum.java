import java.util.HashMap;
import java.util.Map;

class Solution {
        public int[] twoSum(int[] nums, int target) {

            Map<Integer, Integer> numsMap = new HashMap<>();
            
            int xIdx = 0;
            int yIdx = 0;
            for(int i = 0; i < nums.length; i++) {
                
                if(numsMap.containsKey(target-nums[i])) {
                    xIdx = numsMap.get(target-nums[i]);
                    yIdx = i;
                    break;
                }
                    
                
                numsMap.put(nums[i], i);
            }

            return new int[]{xIdx, yIdx};
        }
}