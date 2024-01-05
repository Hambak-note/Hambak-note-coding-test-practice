import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static int n; //저장된 사이트 주소의 수
    private static int m; //찾으려는 사이트 주소의 수
    private static Map<String, String> memo = new HashMap<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());
            memo.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0; i < m; i++) {

            String siteURL = br.readLine();
            System.out.println(memo.get(siteURL));
        }
    }

}
