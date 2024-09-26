import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] fruits = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> fruitNum = new HashMap<>();
        int maxLen = 0;
        int low = 0;

        for (int high = 0; high < n; high++) {

            fruitNum.put(fruits[high], fruitNum.getOrDefault(fruits[high], 0) + 1);

            while (fruitNum.size() > 2) {
                fruitNum.put(fruits[low], fruitNum.get(fruits[low]) -1);

                if(fruitNum.get(fruits[low]) == 0) {
                    fruitNum.remove(fruits[low]);
                }

                low++;
            }
            maxLen = Math.max(maxLen, high - low + 1);
        }

        System.out.println(maxLen);
    }
}
