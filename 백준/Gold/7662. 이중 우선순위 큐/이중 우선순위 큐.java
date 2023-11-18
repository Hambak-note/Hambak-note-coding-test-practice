

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Main {

    static int t; //입력 데이터의 수
    static int k; //연산의 개수

    static TreeMap<Integer, Integer> map;

    private final static String DEL_MAX = "D 1";
    private final static String DEL_MIN = "D -1";
    private final static String EMPTY = "EMPTY";


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            map = new TreeMap<>();

            k = Integer.parseInt(br.readLine());
            for(int i = 0; i < k; i++) {

                String command = br.readLine();
                if(command.charAt(0) == 'I') {
                    int input = Integer.parseInt(command.substring(2));
                    map.put(input, map.getOrDefault(input, 0) + 1);
                    continue;
                }

                if(map.size() == 0) continue;

                if(command.equals(DEL_MIN)) {
                    int key = map.firstKey();
                    int cnt = map.get(key);
                    if(cnt == 1) map.remove(key);
                    else map.put(key, cnt-1);
                    continue;
                }

                if(command.equals(DEL_MAX)) {
                    int key = map.lastKey();
                    int cnt = map.get(key);
                    if(cnt == 1) map.remove(key);
                    else map.put(key, cnt-1);
                }
            }

            if(map.size()==0) System.out.println(EMPTY);
            else System.out.println(map.lastKey() + " " + map.firstKey());
        }
    }
}
