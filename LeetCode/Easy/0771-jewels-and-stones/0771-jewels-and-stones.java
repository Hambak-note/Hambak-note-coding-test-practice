import java.util.HashMap;
import java.util.Map;

class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            Map<Character, Integer> stonesMap = new HashMap<>();
            int result = 0;


            for(int i = 0; i < stones.length(); i++) {
                char stone = stones.charAt(i);
                stonesMap.put(stone, stonesMap.getOrDefault(stone, 0)+1);
            }

            for(int i = 0; i < jewels.length(); i++) {

                char jewel = jewels.charAt(i);
                if(stonesMap.get(jewel) != null) {
                    result += stonesMap.get(jewel);
                }
            }
            return result;
        }
    }