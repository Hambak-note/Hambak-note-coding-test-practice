import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        StringBuilder sb = new StringBuilder();
        sb.append("I");
        for(int i = 0; i < n; i++) {
            sb.append("OI");
        }

        String oi = sb.toString();

        int idx = 0;
        int result = 0;
        while(true) {

            int len = oi.length() + idx;
            if(len > s.length()) break;

            String substring = s.substring(idx, len);
            if(substring.equals(oi)) {
                result++;
                idx += 2;
                continue;
            }
            idx++;
        }

        System.out.println(result);

    }
}
