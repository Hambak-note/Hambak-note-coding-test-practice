import java.util.*; 

class Solution {
        public int solution(String[][] clothes) {
            int answer = 0;

            HashMap<String, Integer> map = new HashMap<String, Integer>();

            for(String[] str : clothes){
                String category = str[1];
                map.put(category, map.getOrDefault(category, 0)+1);
            }

            Iterator<Integer> it = map.values().iterator();
            answer = 1;

            while(it.hasNext())
                answer *= it.next().intValue() +1;


           return answer-1;

        }
    }