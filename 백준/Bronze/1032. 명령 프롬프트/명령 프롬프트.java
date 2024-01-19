

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int testCase;
    private static char[] result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        testCase = Integer.parseInt(br.readLine());

        result = br.readLine().toCharArray();
        testCase--;

        while (testCase-- > 0) {

            char[] input = br.readLine().toCharArray();

            for(int i = 0; i < input.length; i++) {

                if(result[i] != input[i]) {
                    result[i] = '?';
                }
            }
        }

        System.out.println(result);

    }
}
