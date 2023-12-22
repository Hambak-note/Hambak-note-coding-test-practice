

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    private static int N;
    private static long maxCount = 0;
    private static long maxCountInteger = 0;
    private static TreeMap<Long, Long> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        while(N-- > 0) {

            long key = Long.parseLong(br.readLine());
            map.put(key, map.getOrDefault(key, 0L)+1L);
        }

        for (Long key : map.keySet()) {
            long value = map.get(key);
            if(value > maxCount) {
                maxCount = value;
                maxCountInteger = key;
            }
        }

        System.out.println(maxCountInteger);
    }

}
