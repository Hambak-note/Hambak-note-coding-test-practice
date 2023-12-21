

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int inputArr[][] = new int[n][2];

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            inputArr[i][0] = Integer.parseInt(st.nextToken());
            inputArr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(inputArr, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));


        for (int[] ints : inputArr) {
            System.out.println(ints[0] + " " + ints[1]);
        }

    }
}
