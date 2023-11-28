

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static char[] first;
    private static char[] second;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        while(n-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            first = st.nextToken().toCharArray();
            second = st.nextToken().toCharArray();

            Arrays.sort(first);
            Arrays.sort(second);

            if(Arrays.equals(first, second)) System.out.println("Possible");
            else System.out.println("Impossible");
        }
    }
}
