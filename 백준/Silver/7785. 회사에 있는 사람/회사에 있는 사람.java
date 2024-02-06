import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> map = new HashMap<String, String>();

        StringTokenizer st;
        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            String state = st.nextToken();

            if (map.containsKey(name)) {
                map.remove(name);
            } else {
                map.put(name, state);
            }
        }

        ArrayList<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());

        for(var li : list) {
            System.out.print(li + " ");
        }
    }
}