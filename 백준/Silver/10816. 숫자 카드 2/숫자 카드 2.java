import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static int numberCardCnt;
    private static Map<Integer, Integer> numberCardMap = new HashMap<>();
    private static int matchCardCnt;
    private static long[] matchCards;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        numberCardCnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberCardCnt; i++) {
            int key = Integer.parseInt(st.nextToken());
            numberCardMap.put(key, numberCardMap.getOrDefault(key, 0) + 1);
        }

        matchCardCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < matchCardCnt; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(numberCardMap.getOrDefault(key, 0)).append(' ');
        }

        System.out.println(sb);

    }
}
