import java.util.HashMap;

class Solution {
   public static int solution(String str1, String str2) {
        int answer = 0;

        String filteredStr1 = str1.toLowerCase();
        String filteredStr2 = str2.toLowerCase();


        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String, Integer> str2Map = new HashMap<>();
        for(int i = 0; i < filteredStr1.length()-1; i++) {
            String sub = filteredStr1.substring(i, i + 2);
            if(Character.isLetter(sub.charAt(0)) && Character.isLetter(sub.charAt(1))) {
                str1Map.put(sub, str1Map.getOrDefault(sub, 0) + 1);
            }
        }

        for(int i = 0; i < filteredStr2.length()-1; i++) {
            String sub = filteredStr2.substring(i, i + 2);
            if(Character.isLetter(sub.charAt(0)) && Character.isLetter(sub.charAt(1))) {
                str2Map.put(sub, str2Map.getOrDefault(sub, 0) + 1);
            }
        }

        int kyo = 0;
        int hap = 0;
        for (String key : str1Map.keySet()) {
            
            if(!str2Map.containsKey(key)) {
                hap += str1Map.get(key);
                continue;
            }

            int str1Cnt = str1Map.get(key);
            int str2Cnt = str2Map.get(key);

            kyo += Math.min(str1Cnt, str2Cnt);
            hap += Math.max(str1Cnt, str2Cnt);

            str2Map.remove(key);
        }

        if(!str2Map.isEmpty()) {
            for (String key : str2Map.keySet()) {
                hap += str2Map.get(key);
            }
        }

        if(hap == 0) return 65536;

        double result = ((double) kyo / hap) * 65536;
        answer = (int) Math.floor(result);

        return answer;
    }
}