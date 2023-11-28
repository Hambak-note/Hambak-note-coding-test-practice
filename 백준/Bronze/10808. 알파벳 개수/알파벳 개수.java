

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static String input;
    private static int[] count = new int[26];
    private static int MINUS = 97;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        for(int i = 0; i < input.length(); i++) {

            int cur = input.charAt(i)-MINUS;
            count[cur]++;
        }

        for(int i = 0; i < count.length; i++) {
            System.out.print(count[i] + " ");
        }
        System.out.println();
    }
}
