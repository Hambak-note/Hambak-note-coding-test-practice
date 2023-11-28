import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static char[] first;
    private static char[] second;
    private static int[][] arr = new int[2][26];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        first = br.readLine().toCharArray();

        for (char cur : first) {
            arr[0][cur - 'a']++;
        }

        second = br.readLine().toCharArray();
        for (char cur : second) {
            arr[1][cur - 'a']++;
        }

        int count = 0;
        for(int i = 0; i < 26; i++) {
            count += Math.abs(arr[0][i] - arr[1][i]);
        }

        System.out.println(count);
    }
}
