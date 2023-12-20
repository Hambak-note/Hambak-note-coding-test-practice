import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static TreeMap<Integer, List<String>> inputTreeMap
            = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        while(N-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            addValue(age, name);

        }

        for(Integer key : inputTreeMap.keySet()) {
            List<String> values = inputTreeMap.get(key);
            for (String value : values) {
                System.out.println(key + " " + value);
            }
        }
    }

    private static void addValue(Integer key, String value) {

        inputTreeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
}
