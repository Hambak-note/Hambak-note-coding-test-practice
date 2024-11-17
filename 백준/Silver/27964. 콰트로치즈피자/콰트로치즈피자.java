import java.io.*;
import java.util.*;

public class Main {

    private static int n; // 토핑의 개수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        Set<String> s = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {

            String input = st.nextToken();
            if(input.endsWith("Cheese")) s.add(input);
        }

        if(s.size() < 4) System.out.println("sad");
        else System.out.println("yummy");
    }
}
