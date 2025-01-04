

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    private static int t, p, q;

    private static final int MAx_P = 10_000;


    public static void main(String... args) throws IOException {

        List<BigInteger> memo = new ArrayList<>();

        memo.add(BigInteger.ZERO);
        memo.add(BigInteger.ONE);

        for(int i = 2; i <= MAx_P; i++) {
            memo.add(memo.get(i - 1).add(memo.get(i - 2)));
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        for(int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            p = Integer.parseInt(st.nextToken());
            q = Integer.parseInt(st.nextToken());

            System.out.printf("Case #%d: %d\n", i, (memo.get(p).mod(BigInteger.valueOf(q))));
        }
    }
}
